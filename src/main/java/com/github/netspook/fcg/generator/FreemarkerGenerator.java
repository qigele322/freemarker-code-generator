package com.github.netspook.fcg.generator;

import com.github.netspook.fcg.engine.FreemarkerEngine;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerGenerator {

    private Configuration engine = FreemarkerEngine.getInstance();

    private Template template;

    private Map parameters;

    private StringWriter writer;

    public FreemarkerGenerator() {
        template = null;
        parameters = null;
        writer = null;
    }

    public static FreemarkerGenerator getInstance(String templateSource, Map parameters) throws IOException {
        FreemarkerGenerator freemarkerGenerator = new FreemarkerGenerator();
        freemarkerGenerator.setTemplateSource(templateSource);
        freemarkerGenerator.setParameters(parameters);

        return freemarkerGenerator;
    }

    public void setTemplateSource(String templateSource) throws IOException {

        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", templateSource);

        engine.setTemplateLoader(stringTemplateLoader);

        template = engine.getTemplate("template");
    }

    public Template getTemplate() {
        return template;
    }

    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    public StringWriter getWriter() {
        return writer;
    }

    public void run() throws IOException, TemplateException {

        StringWriter stringWriter = new StringWriter();
        template.process(parameters, stringWriter);

        writer = stringWriter;
    }
}
