package com.yl.maven.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeaderDecorator implements LineDecorator {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeaderDecorator.class.getName());

    @Override
    public String decorate(String line) {
        String stripped = line.replaceAll("^#+", "");
        int num = line.length() - stripped.length();
        if (num > 0) {
            LOGGER.debug("Decorating line with h{}", num);
            return String.format("<h%d>%s</h%1$d>", num, stripped.trim());
        }
        LOGGER.debug("Line is a simple paragraph");
        return "<p>" + line + "</p>";
    }
}
