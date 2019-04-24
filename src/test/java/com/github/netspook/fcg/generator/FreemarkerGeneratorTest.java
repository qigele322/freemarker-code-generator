package com.github.netspook.fcg.generator;

import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FreemarkerGeneratorTest {

    @Test
    public void getInstance() throws IOException, TemplateException {
        String templateSource = "测试:${test}, Hello ${name}";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("test", "response");
        parameters.put("name", "世界");

        FreemarkerGenerator generator = FreemarkerGenerator.getInstance(templateSource, parameters);

        generator.run();

        System.out.println("writer: " + generator.getWriter().toString());

        assertEquals("测试:response, Hello 世界", generator.getWriter().toString());

    }
}