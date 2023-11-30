package com.example.config.client;

import org.springframework.cloud.zookeeper.ZookeeperProperties;

import java.time.Duration;

public class MyZookeeperProperties extends ZookeeperProperties {

    private static final String LOCAL_ZK = "local.zookeeper.invalid";

    public MyZookeeperProperties() {
        System.out.println("[_____] Created new instance " + this);
    }

    @Override
    public String getConnectString() {
        String connectString = super.getConnectString();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getConnectString() = " + connectString);
        return connectString;
    }

    @Override
    public void setConnectString(String connectString) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "setConnectString(" + connectString + ")");
        super.setConnectString(
                LOCAL_ZK.equals(connectString) ? "localhost:2181" : connectString);
    }

    @Override
    public Duration getConnectionTimeout() {
        Duration connectionTimeout = super.getConnectionTimeout();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getConnectionTimeout() = " + connectionTimeout);
        return connectionTimeout;
    }

    @Override
    public void setConnectionTimeout(Duration connectionTimeout) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "setConnectionTimeout(" + connectionTimeout + ")");
        super.setConnectionTimeout(connectionTimeout);
    }

    @Override
    public Integer getBlockUntilConnectedWait() {
        Integer blockUntilConnectedWait = super.getBlockUntilConnectedWait();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getBlockUntilConnectedWait() = " + blockUntilConnectedWait);
        return blockUntilConnectedWait;
    }

    @Override
    public void setBlockUntilConnectedWait(Integer blockUntilConnectedWait) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "setBlockUntilConnectedWait(" + blockUntilConnectedWait + ")");
        super.setBlockUntilConnectedWait(blockUntilConnectedWait);
    }

    @Override
    public Integer getBaseSleepTimeMs() {
        Integer baseSleepTimeMs = super.getBaseSleepTimeMs();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getBaseSleepTimeMs() = " + baseSleepTimeMs);
        return baseSleepTimeMs;
    }

    @Override
    public void setBaseSleepTimeMs(Integer baseSleepTimeMs) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "setBaseSleepTimeMs(" + baseSleepTimeMs + ")");
        super.setBaseSleepTimeMs(baseSleepTimeMs);
    }

    @Override
    public Integer getMaxRetries() {
        Integer maxRetries = super.getMaxRetries();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getMaxRetries() = " + maxRetries);
        return maxRetries;
    }

    @Override
    public void setMaxRetries(Integer maxRetries) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "setMaxRetries(" + maxRetries + ")");
        super.setMaxRetries(maxRetries);
    }

    @Override
    public Integer getMaxSleepMs() {
        Integer maxSleepMs = super.getMaxSleepMs();
        System.out.println("[_____] Instance " + this + " is executing " +
                "getMaxSleepMs() = " + maxSleepMs);
        return maxSleepMs;
    }

    @Override
    public void setMaxSleepMs(Integer maxSleepMs) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "setMaxSleepMs(" + maxSleepMs + ")");
        super.setMaxSleepMs(maxSleepMs);
    }
}
