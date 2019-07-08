package com.example.code_scenarios;

import net.sf.ehcache.concurrent.ConcurrencyUtil;
import org.apache.jmeter.control.LoopController;
import org.apache.jmeter.control.RandomController;
import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.SetupThreadGroup;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;
import sun.misc.ThreadGroupUtils;

public class RunThreadGroup {

    public static void main(String[] args) {



        // Engine
        StandardJMeterEngine jm = new StandardJMeterEngine();
        // jmeter.properties
        JMeterUtils.loadJMeterProperties("c:/tmp/jmeter.properties");

        HashTree hashTree = new HashTree();


        HTTPSampler sampler = new HTTPSampler();
        sampler.setDomain("localhost");
        sampler.setPort(3000);
        sampler.setPath("/posts");
        sampler.setMethod("GET");
        // Arguments arg = new Arguments();
        // arg.addArgument("categoryId", "FISH");
        // sampler.setArguments(arg);


        LoopController get_posts = new LoopController();
        get_posts.setLoops(1);
        get_posts.addTestElement(sampler);
        get_posts.setFirst(true);
        get_posts.setContinueForever(true);

        // Thread Group
        ThreadGroup threadGroup = new ThreadGroup();
        threadGroup.setSamplerController(get_posts);
        threadGroup.setNumThreads(10);
        threadGroup.setRampUp(5);

        // Test plan
        TestPlan testPlan = new TestPlan("Load Testing");

        hashTree.add("testPlan", testPlan);
        hashTree.add("loopCtrl", get_posts);
        hashTree.add("threadGroup", threadGroup);
        hashTree.add("httpSampler", sampler);

        jm.configure(hashTree);

        jm.run();



    }


}
