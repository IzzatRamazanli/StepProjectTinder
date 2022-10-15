package com.tinder.util;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


public class TemplateEngine {


    private final Configuration configuration;

    public TemplateEngine(Object obj) {
        configuration = new Configuration(Configuration.VERSION_2_3_31) {{
            setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
            setClassForTemplateLoading(obj.getClass(), "/templates/");
            setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            setLogTemplateExceptions(false);
            setWrapUncheckedExceptions(true);
        }};
    }

    public void render(String fileName, HashMap<String, Object> data, HttpServletResponse response) throws IOException {
        try (PrintWriter writer = response.getWriter()) {
            //response.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
            configuration.getTemplate(fileName).process(data, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
