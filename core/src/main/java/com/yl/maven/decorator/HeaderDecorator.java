package com.yl.maven.decorator;

public class HeaderDecorator implements LineDecorator {
    @Override
    public String decorate(String line) {
        String stripped = line.replaceAll("^#+", "");
        int num = line.length() - stripped.length();
        if (num > 0) {
            return String.format("<h%d>%s</h%1$d>", num, stripped.trim());
        }
        return "<p>" + line + "</p>";
    }
}
