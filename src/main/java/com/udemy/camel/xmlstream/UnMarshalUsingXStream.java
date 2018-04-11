package com.udemy.camel.xmlstream;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnMarshalUsingXStream extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        Map<String, String> aliases = new HashMap<>();
        aliases.put("employee", Employee.class.getName());

        XStreamDataFormat dataFormat = new XStreamDataFormat();
        dataFormat.setAliases(aliases);
        dataFormat.setPermissions(Employee.class.getName());

        from("direct:xmlInput")
                .unmarshal(dataFormat)
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
}
