package com.udemy.camel.gson;

import com.udemy.camel.xmlstream.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);

        from("direct:gsonRoute")
                .log("Before Marshaling is : ${body}")
                .marshal(gsonDataFormat)
                .log("Marshaled Object is : ${body}")
                .to("mock:output");

    }

}
