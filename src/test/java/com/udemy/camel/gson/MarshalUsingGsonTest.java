package com.udemy.camel.gson;

import com.udemy.camel.xmlstream.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalUsingGson(){

        Employee e = new Employee();
        e.setId("1");
        e.setName("Elvis");
        e.setJoinDate("12Jan2017");

        String response = template.requestBody("direct:gsonRoute", e, String.class);
        String expected = "{\"id\":\"1\",\"name\":\"Elvis\",\"joinDate\":\"12Jan2017\"}";

        assertEquals(expected, response);
    }

    @Test
    public void marshalGsonWithMockOutput() throws InterruptedException {
        Employee e = new Employee();
        e.setId("1");
        e.setName("Elvis");
        e.setJoinDate("12Jan2017");

        String expected = "{\"id\":\"1\",\"name\":\"Elvis\",\"joinDate\":\"12Jan2017\"}";


        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(expected);

        template.sendBody("direct:gsonRoute", e);

        assertMockEndpointsSatisfied();
    }
}
