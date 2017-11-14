package com.udemy.camel.com.udemy.camel.files;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesComelMultRoute {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:data/input?noop=true")
                        //.log("Received Message is ${body}")// and Headers are ${headers}")
                        .to("log:?level=INFO&showBody=true&showHeaders=true")
                        .to("file:data/output")
                        .to("file:data/output2");

                from("file:data/input2?noop=true")
                        //.log("Received Message is ${body}")// and Headers are ${headers}")
                        .to("log:?level=INFO&showBody=true&showHeaders=true")
                        .to("file:data/output2");
            }
        });

        context.start();
        Thread.sleep(5000);
        context.stop();

    }
}
