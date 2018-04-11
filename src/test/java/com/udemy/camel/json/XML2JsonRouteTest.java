package com.udemy.camel.json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JsonRouteTest extends CamelTestSupport{


    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {

        return new XML2JsonRoute();
    }

    @Test
    public void marshalEmployee2JsonXml(){

        String expected = "{\"id\":\"123\",\"name\":\"dilip\",\"joinDate\":\"12JAN2017\"}";
        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>dilip</name><joinDate>12JAN2017</joinDate></employee>";
        String response = template.requestBody("direct:marshalEmployeeJson", input, String.class);

       assertEquals(expected, response);

    }

    @Test
    public void unMarshalEmployee2JsonXml(){

        String input = "{\"id\":\"123\",\"name\":\"dilip\",\"joinDate\":\"12JAN2017\"}";
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><id>123</id><joinDate>12JAN2017</joinDate><name>dilip</name></employee>\r\n";

        String response = template.requestBody("direct:unMarshalEmployeeJson", input, String.class);

        System.out.println("**"+response+"**");

        assertEquals(expected, response);

    }
}
