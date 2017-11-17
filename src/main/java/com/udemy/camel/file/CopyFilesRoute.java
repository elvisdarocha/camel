package com.udemy.camel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesRoute extends RouteBuilder{


    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .to("file:data/output");
    }
}
