package com.udemy.camel.transform.route;

import com.udemy.camel.transform.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/transform/input?noop=true")
                .process(new CamelFileExampleProcessor())
                .log("Receive Message is ${body} and Headers are ${headers}")
                .to("file:data/transform/output?fileName=output.txt")
                .to("mock:output");
    }
}
