package com.udemy.camel.transform;

import com.udemy.camel.transform.route.CamelModifyTransformRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyTransformRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyTransformRoute();
    }

    @Test
    public void transformTest(){

        String expected = "123*dilip*12JAN2017";
        String output = (String) template.requestBody("direct:transformInput","123,dilip,12JAN2017" );
        System.out.println("output : "+ output);

        assertEquals(expected,output);
    }

    @Test
    public void transformTest_Uisng_Mock() throws InterruptedException {

        String expected = "123*dilip*12JAN2017";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expected);

        template.sendBody("direct:transformInput","123,dilip,12JAN2017" );

        assertMockEndpointsSatisfied();
    }
}
