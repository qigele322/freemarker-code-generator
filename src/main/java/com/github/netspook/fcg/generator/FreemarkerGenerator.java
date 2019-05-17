package com.github.netspook.fcg.generator;

import com.github.netspook.fcg.engine.FreemarkerEngine;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class FreemarkerGenerator implements Generator {

    private Configuration engine = FreemarkerEngine.getInstance();

    private Template template;

    private Map parameters;

    private StringWriter writer;

    public FreemarkerGenerator() {
        template = null;
        parameters = null;
        writer = null;
    }

    public static Generator getInstance(String templateSource, Map parameters) throws IOException {
        FreemarkerGenerator freemarkerGenerator = new FreemarkerGenerator();
        freemarkerGenerator.setTemplateSource(templateSource);
        freemarkerGenerator.setParameters(parameters);

        return freemarkerGenerator;
    }

    public static Generator getInstance(File templateSource, Map parameters) throws IOException {
        FreemarkerGenerator freemarkerGenerator = new FreemarkerGenerator();
        freemarkerGenerator.setTemplateSource(templateSource);
        freemarkerGenerator.setParameters(parameters);

        return freemarkerGenerator;
    }

    /**
     * 从文本生成template
     * @param templateSource
     * @throws IOException
     */
    public void setTemplateSource(String templateSource) throws IOException {

        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        stringTemplateLoader.putTemplate("template", templateSource);

        engine.setTemplateLoader(stringTemplateLoader);

        template = engine.getTemplate("template");
    }

    /**
     * 从文件生成template
     * @param templateSource
     * @throws IOException
     */
    public void setTemplateSource(File templateSource) throws IOException {

        File dir = templateSource.getParentFile();

        engine.setDirectoryForTemplateLoading(dir);

        template = engine.getTemplate(templateSource.getName());
    }

    public Template getTemplate() {
        return template;
    }

    /**
     * 设置模板参数
     * @param parameters
     */
    public void setParameters(Map parameters) {
        this.parameters = parameters;
    }

    /**
     * 获取输出流
     * @return
     */
    public StringWriter getWriter() {
        return writer;
    }

    /**
     * 运行模板编译程序
     * @throws Exception
     */
    public void run() throws Exception {

        StringWriter stringWriter = new StringWriter();
        template.process(parameters, stringWriter);

        writer = stringWriter;
    }
}
