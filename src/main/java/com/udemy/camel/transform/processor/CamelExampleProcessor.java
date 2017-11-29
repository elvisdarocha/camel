package com.udemy.camel.transform.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelExampleProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {

        try{
            String oldValue = (String) exchange.getIn().getBody();

            System.out.println("Old Value is : " + oldValue);

            String newValue = oldValue.replace(",", ":");

            System.out.println("New Value is :  " + newValue);

            exchange.getIn().setBody(newValue);

        }catch (Exception e){
            System.out.println("Exception in processor is : " + e);
        }

    }
}
