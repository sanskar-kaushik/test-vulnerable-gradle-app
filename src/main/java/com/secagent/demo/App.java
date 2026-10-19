package com.secagent.demo;

import org.apache.commons.text.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public String escape(String input) {
        return StringEscapeUtils.escapeHtml4(input);
    }

    public static void main(String[] args) {
        LOGGER.info("SecAgent Gradle test application");
        System.out.println(new App().escape("<sample>"));
    }
}
