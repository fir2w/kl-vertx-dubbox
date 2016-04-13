
package com.klwork.spring.vertx.jmx;

import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import java.util.concurrent.atomic.AtomicInteger;

public class Util
{
    private final static AtomicInteger id = new AtomicInteger(0);
    
    public static ObjectName getUniqueObjectName()
    {
        try {
            return new ObjectName(Util.class.getName() + ":name=instance_" + id.incrementAndGet());
        }
        catch (MalformedObjectNameException e) {
            throw new AssertionError(e);
        }
    }

}
