package com.example.config.client;

import org.apache.curator.utils.DefaultTracerDriver;

import java.util.concurrent.TimeUnit;

public class MyTracerDriver extends DefaultTracerDriver {

    public MyTracerDriver() {
        System.out.println("[_____] Created new instance " + this);
    }

    @Override
    public void addTrace(String name, long time, TimeUnit unit) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "addTrace(" + name + ", " + time + ", " + unit + ")");
        super.addTrace(name, time, unit);
    }

    @Override
    public void addCount(String name, int increment) {
        System.out.println("[_____] Instance " + this + " is executing " +
                "addCount(" + name + ", " + increment + ")");
        super.addCount(name, increment);
    }
}
