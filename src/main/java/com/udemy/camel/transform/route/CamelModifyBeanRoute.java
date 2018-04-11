package com.udemy.camel.transform.route;

import com.udemy.camel.bean.CamelBean;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyBeanRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:beanInput")
                .log("Before bean is : ${body}")
                .bean(new CamelBean(), "map2")
                .log("After Bean is : ${body}")
                .to("mock:output");
    }
}
