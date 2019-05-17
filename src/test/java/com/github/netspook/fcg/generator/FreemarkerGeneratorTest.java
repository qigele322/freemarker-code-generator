package com.github.netspook.fcg.generator;

import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FreemarkerGeneratorTest {

    @Test
    public void getInstance() throws Exception {
        String templateSource = "测试:${test}, Hello ${name}";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("test", "response");
        parameters.put("name", "世界");

        Generator generator = FreemarkerGenerator.getInstance(templateSource, parameters);

        generator.run();

        System.out.println("writer: " + generator.getWriter().toString());

        assertEquals("测试:response, Hello 世界", generator.getWriter().toString());

    }

    @Test
    public void getInstance1() throws Exception {
        File templateSource = new File("/Users/qigele/Documents/freemarkertest.ftl");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("test", "response");
        parameters.put("name", "世界");

        Generator generator = FreemarkerGenerator.getInstance(templateSource, parameters);

        generator.run();

        System.out.println("writer: " + generator.getWriter().toString());

        assertEquals("文件测试:response, Hello 世界", generator.getWriter().toString());
    }
}