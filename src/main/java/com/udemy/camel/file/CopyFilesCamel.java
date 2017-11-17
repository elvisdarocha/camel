package com.udemy.camel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesCamel {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new CopyFilesRoute());
        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
