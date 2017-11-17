package com.udemy.camel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SimpleDirectRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SimpleDirectRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {

        template.sendBody("direct:sampleInput", "Hello");

        Thread.sleep(5000);

        File sampleOutput = new File("sampleOutput");

        assertTrue(sampleOutput.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");

        System.out.println("Received body is : " + exchange.getIn().getBody());
        System.out.println("File Name is : " + exchange.getIn().getHeader("CamelFileName"));

        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}
