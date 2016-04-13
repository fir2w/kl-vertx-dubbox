package com.klwork.spring.vertx.jmx;

import org.weakref.jmx.MBeanExporter;

import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;

/**
 * Created by young on 16/1/6.
 */
public class MBeanRegister {
    private MBeanServer server = null;
    private MBeanExporter exporter = null;

    public void register(String name, Object bean) {
        server = ManagementFactory.getPlatformMBeanServer();
        exporter = new MBeanExporter(server);
        exporter.export(name, bean);
    }
}
