package com.example.config.client;

import org.apache.curator.framework.CuratorFrameworkFactory;
import org.springframework.cloud.zookeeper.CuratorFrameworkCustomizer;

public class MyCuratorFrameworkCustomizer implements CuratorFrameworkCustomizer {

    public MyCuratorFrameworkCustomizer() {
        System.out.println("[_____] Created new instance " + this);
    }

    @Override
    public void customize(CuratorFrameworkFactory.Builder builder) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "customize(" + builder + ")");
    }
}
