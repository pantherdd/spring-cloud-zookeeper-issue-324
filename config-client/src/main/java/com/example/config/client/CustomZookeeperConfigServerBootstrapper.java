package com.example.config.client;

import org.apache.curator.RetryPolicy;
import org.apache.curator.drivers.TracerDriver;
import org.apache.curator.ensemble.EnsembleProvider;
import org.springframework.boot.BootstrapContext;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.cloud.config.client.ConfigClientProperties;
import org.springframework.cloud.zookeeper.CuratorFrameworkCustomizer;
import org.springframework.cloud.zookeeper.ZookeeperProperties;
import org.springframework.cloud.zookeeper.discovery.ConditionalOnZookeeperDiscoveryEnabled;
import org.springframework.cloud.zookeeper.discovery.configclient.ZookeeperConfigServerBootstrapper;
import org.springframework.core.annotation.Order;
import org.springframework.util.ClassUtils;

/**
 * @see ZookeeperConfigServerBootstrapper
 */
@Order(-1)
public class CustomZookeeperConfigServerBootstrapper implements BootstrapRegistryInitializer {

    /**
     * @see ZookeeperConfigServerBootstrapper#initialize(BootstrapRegistry)
     */
    @Override
    public void initialize(BootstrapRegistry registry) {
        if (!ClassUtils.isPresent("org.springframework.cloud.config.client.ConfigServerInstanceProvider", null) ||
                // don't run if bootstrap enabled, how to check the property?
                ClassUtils.isPresent("org.springframework.cloud.bootstrap.marker.Marker", null)) {
            return;
        }

        registerIfAbsentAndEnabled(registry, ZookeeperProperties.class, context ->
                context.get(Binder.class)
                        .bind(ZookeeperProperties.PREFIX, Bindable.of(MyZookeeperProperties.class))
                        .orElseGet(MyZookeeperProperties::new));

        registerIfAbsentAndEnabled(registry, RetryPolicy.class, context ->
                new MyRetryPolicy(context.get(ZookeeperProperties.class)));

        registerIfAbsentAndEnabled(registry, CuratorFrameworkCustomizer.class, context ->
                new MyCuratorFrameworkCustomizer());

        registerIfAbsentAndEnabled(registry, EnsembleProvider.class, context ->
                new MyEnsembleProvider(context.get(ZookeeperProperties.class)));

        registerIfAbsentAndEnabled(registry, TracerDriver.class, context ->
                new MyTracerDriver());
    }

    private static <T> void registerIfAbsentAndEnabled(
            BootstrapRegistry registry, Class<T> type, BootstrapRegistry.InstanceSupplier<T> supplier) {
        registry.registerIfAbsent(type, context -> isEnabled(context) ? supplier.get(context) : null);
    }

    /**
     * @see ZookeeperConfigServerBootstrapper#isEnabled(Binder)
     */
    private static boolean isEnabled(BootstrapContext context) {
        Binder binder = context.get(Binder.class);
        return binder.bind(ConfigClientProperties.CONFIG_DISCOVERY_ENABLED, Boolean.class).orElse(false) &&
                binder.bind(ConditionalOnZookeeperDiscoveryEnabled.PROPERTY, Boolean.class).orElse(true) &&
                binder.bind("spring.cloud.discovery.enabled", Boolean.class).orElse(true);
    }
}
