package com.cybertek.tests.day9_properties_browser_utils;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        //#1 - Create object of Properties class (coming from Java library)

        Properties properties = new Properties();

        //#2 - Open the file using FileInputStream
        //We are trying to open a file so we need to pass the path
        FileInputStream file = new FileInputStream("configuration.properties");

        //#3 - load the properties object with our file
        properties.load(file);

        //reading from configuration properties
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));


    }
}
