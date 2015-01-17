package com.yl.maven.decorator;

public class BoldDecorator implements LineDecorator {
    @Override
    public String decorate(String line) {
        return line.replaceAll("\\*\\*([^*]+)\\*\\*", "<strong>$1</strong>");
    }
}
