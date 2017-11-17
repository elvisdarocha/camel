package com.udemy.camel.files;

import com.udemy.camel.file.CopyFilesRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CopyFilesCamelTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CopyFilesRoute();
    }

    @Test
    public void checkFileExistsInOutputDirectory() throws InterruptedException {
        Thread.sleep(5000);

        File outputDirectory = new File("data/output");

        assertTrue(outputDirectory.isDirectory());
    }
}
