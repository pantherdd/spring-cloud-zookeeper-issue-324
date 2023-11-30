package com.example.config.client;

import org.apache.curator.ensemble.fixed.FixedEnsembleProvider;
import org.springframework.cloud.zookeeper.ZookeeperProperties;

public class MyEnsembleProvider extends FixedEnsembleProvider {

    public MyEnsembleProvider(ZookeeperProperties properties) {
        super(properties.getConnectString());
        System.out.println("[_____] Created new instance " + this + " using " + properties);
    }

    @Override
    public String getConnectionString() {
        String connectionString = super.getConnectionString();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getConnectionString() = " + connectionString);
        return connectionString;
    }
}
