package com.udemy.camel.transform;

import com.udemy.camel.transform.route.CamelModifyBeanRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyBeanRouteTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyBeanRoute();
    }

    @Test
    public void beanTest(){
        String expected = "123*dilip*12JAN2017";
        String input = "123,dilip,12JAN2017";

        String actual = (String) template.requestBody("direct:beanInput", input);

        assertEquals(expected, actual);
    }
}
