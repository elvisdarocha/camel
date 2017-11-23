package com.udemy.camel.transform;

import com.udemy.camel.transform.route.CamelModifyFileProcessorRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        Thread.sleep(5000);

        File file = new File("data/transform/output");

        assertTrue(file.isDirectory());
        assertEquals(1, file.listFiles().length);

    }

    @Test
    public void processorMockTest() throws InterruptedException {
        String expected = "123:dilip:12JAN2017\n" +
                "456:Aaam:12JAN2017\n";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        Thread.sleep(5000);

        assertMockEndpointsSatisfied();

    }
}
