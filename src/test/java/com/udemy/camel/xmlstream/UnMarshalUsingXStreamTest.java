package com.udemy.camel.xmlstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnMarshalUsingXStreamTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new UnMarshalUsingXStream();
    }

    @Test
    public void unMarshalXStreamTeste() throws InterruptedException {
        Employee e = new Employee();
        e.setJoinDate("12Jan2017");
        e.setName("Daniel");
        e.setId("124");

        String xmlInput = "<?xml version='1.0' encoding='UTF-8'?><employee><id>124</id><name>Daniel</name><joinDate>12Jan2017</joinDate></employee>";

        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(e.toString());

        template.sendBody("direct:xmlInput", xmlInput);

        assertMockEndpointsSatisfied();
    }
}
