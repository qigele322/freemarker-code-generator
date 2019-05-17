package com.github.netspook.fcg.generator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public interface Generator {

    void setTemplateSource(String templateSource) throws IOException;

    void setParameters(Map parameters);

    StringWriter getWriter();

    void run() throws Exception;
}
