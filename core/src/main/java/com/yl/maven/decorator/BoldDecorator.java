package com.yl.maven.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoldDecorator implements LineDecorator {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoldDecorator.class.getName());
    private Pattern pattern = Pattern.compile("\\*\\*([^*]+)\\*\\*");

    @Override
    public String decorate(String line) {
        Matcher m = pattern.matcher(line);
        if (m.find()) {
            LOGGER.debug("Decorating line {} with bold", line);
            return m.replaceAll("<strong>$1</strong>");
        }
        return line;
    }
}
