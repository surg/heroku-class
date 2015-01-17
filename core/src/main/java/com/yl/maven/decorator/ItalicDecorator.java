package com.yl.maven.decorator;

public class ItalicDecorator implements LineDecorator {
    @Override
    public String decorate(String line) {
        return line.replaceAll("([^*]|^)\\*([^*]+)\\*", "$1<em>$2</em>");
    }
}
