package com.github.netspook.fcg.engine;

import freemarker.template.Configuration;

import java.util.Locale;

public class FreemarkerEngine {

    private static Configuration configuration;

    public static synchronized Configuration getInstance() {
        if (configuration == null) {
            configuration = new Configuration();

            configuration.setEncoding(Locale.CHINA, "utf-8");
        }

        return configuration;
    }
}
