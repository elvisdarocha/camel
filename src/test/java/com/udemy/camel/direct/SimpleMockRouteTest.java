package com.udemy.camel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SimpleMockRouteTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleMockRoute();
    }

    @Test
    public void sampleRouteTest() throws InterruptedException {


        String expected = "Hello";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        String input = "Hello";
        template.sendBody("direct:sampleInput", input);

        assertMockEndpointsSatisfied();
    }
}
