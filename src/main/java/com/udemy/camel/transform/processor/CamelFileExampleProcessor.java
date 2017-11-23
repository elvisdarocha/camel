package com.udemy.camel.transform.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements Processor{

    String newValue = "";

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("exchange is: " + exchange.getIn().getBody());


        File file = new File((String) exchange.getIn().getHeaders().get("CamelFilePath"));
        String readLine=null;

        if(file!=null){

            FileReader file1 = new FileReader(file);
            BufferedReader reader = new BufferedReader(file1);

            while((readLine =reader.readLine()) !=null){
                System.out.println("Read line is : " + readLine);

                String oldValue = readLine;

                System.out.println("Old Value is : " + oldValue);

                newValue = newValue.concat(oldValue.replace(",", ":")).concat("\n");

                System.out.println("New Value is :  " + newValue);

                exchange.getIn().setBody(newValue);
            }

        }


    }
}
