package com.udemy.camel.xmlstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public void marshalXstreamTest() throws InterruptedException {
        String input = "123,dilip,12JAN2017";
        //String expected = "<?xml version='1.0' encoding='UTF-8'?><com.udemy.camel.xmlstream.Employee><id>123</id><name>dilip</name><joinDate>12JAN2017</joinDate></com.udemy.camel.xmlstream.Employee>";
        String expected = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>dilip</name><joinDate>12JAN2017</joinDate></employee>";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expected);
        template.sendBody("direct:csvinput", input);

        assertMockEndpointsSatisfied();
    }

}
