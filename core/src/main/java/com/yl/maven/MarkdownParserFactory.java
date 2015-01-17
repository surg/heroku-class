package com.yl.maven;

import com.google.common.collect.Lists;
import com.yl.maven.decorator.BoldDecorator;
import com.yl.maven.decorator.HeaderDecorator;
import com.yl.maven.decorator.ItalicDecorator;
import com.yl.maven.decorator.LineDecorator;

import java.util.List;

public class MarkdownParserFactory {

    public MarkdownParser createParser() {
        List<LineDecorator> decorators = Lists.newArrayList(
                new HeaderDecorator(),
                new BoldDecorator(),
                new ItalicDecorator()
        );
        return new MarkdownParserImpl(decorators);
    }
}
