package com.example.config.client;

import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.cloud.zookeeper.ZookeeperProperties;

public class MyRetryPolicy extends ExponentialBackoffRetry {

    public MyRetryPolicy(ZookeeperProperties properties) {
        super(properties.getBaseSleepTimeMs(), properties.getMaxRetries(), properties.getMaxSleepMs());
        System.out.println("[_____] Created new instance " + this + " using " + properties);
    }

    @Override
    protected long getSleepTimeMs(int retryCount, long elapsedTimeMs) {
        long sleepTimeMs = super.getSleepTimeMs(retryCount, elapsedTimeMs);
        System.out.println("[_____] Instance " + this + " is executing " +
                "getSleepTimeMs(" + retryCount + ", " + elapsedTimeMs + ") = " + sleepTimeMs);
        return sleepTimeMs;
    }
}
