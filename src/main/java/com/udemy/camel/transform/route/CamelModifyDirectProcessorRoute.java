package com.udemy.camel.transform.route;

import com.udemy.camel.transform.processor.CamelExampleProcessor;
import com.udemy.camel.transform.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {

    public void configure() throws Exception {

        from("direct:processorInput")
                .process(new CamelExampleProcessor())
                .log("Received Message is ${body} and Headers are ${headers}")
                //.to("file:data/output?fileName=output.txt");
                .to("mock:output");
    }
}
