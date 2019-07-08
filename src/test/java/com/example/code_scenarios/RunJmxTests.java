package com.example.code_scenarios;

import org.apache.jmeter.engine.JMeterEngine;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class RunJmxTests {

    public static void main(String[] args) throws IOException {

        StandardJMeterEngine jmeter = new StandardJMeterEngine();

        // Initialize Properties, logging, locale, etc.
        JMeterUtils.loadJMeterProperties("/src/test/resources/jmeter.properties");
        JMeterUtils.setJMeterHome("/usr/local/bin/jmeter");
        JMeterUtils.loadProperties("/src/test/resources/user.properties");
        JMeterUtils.initLocale();

        SaveService.loadProperties();

        // Load existing .jmx Test Plan
        File testScript = new File("/path/to/your/jmeter/extras/Test.jmx");
        HashTree testPlanTree = SaveService.loadTree(testScript);

        // Run JMeter Test
        jmeter.configure(testPlanTree);
        jmeter.run();

    }

}
