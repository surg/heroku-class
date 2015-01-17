package com.yl.maven;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.yl.maven.decorator.LineDecorator;

import java.util.Collection;

public class MarkdownParserImpl implements MarkdownParser {
    private Collection<LineDecorator> decorators;

    public MarkdownParserImpl(Collection<LineDecorator> decorators) {
        this.decorators = decorators;
    }

    @Override
    public Collection<String> parse(Collection<String> strings) {
        return Collections2.transform(strings, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return applyDecorators(s);
            }
        });
    }

    private String applyDecorators(String s) {
        for (LineDecorator ld : decorators) {
            s = ld.decorate(s);
        }
        return s;
    }
}
