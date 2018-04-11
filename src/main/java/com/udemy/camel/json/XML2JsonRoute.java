package com.udemy.camel.json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class XML2JsonRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:marshalEmployeeJson")
                .to("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .to("log:?level=INFO&showBody=true");


        XmlJsonDataFormat jsonDataFormat = new XmlJsonDataFormat();
        jsonDataFormat.setRootName("employee");

        from("direct:unMarshalEmployeeJson")
                .to("log:?level=INFO&showBody=true")
                //.unmarshal(jsonDataFormat).xmljson()
                .unmarshal(jsonDataFormat)
                .to("log:?level=INFO&showBody=true");
    }
}
