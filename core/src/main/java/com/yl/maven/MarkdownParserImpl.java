package com.yl.maven;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.yl.maven.decorator.LineDecorator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class MarkdownParserImpl implements MarkdownParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(MarkdownParser.class.getName());

    private Collection<LineDecorator> decorators;

    public MarkdownParserImpl(Collection<LineDecorator> decorators) {
        this.decorators = decorators;
    }

    @Override
    public Collection<String> parse(Collection<String> strings) {
        LOGGER.info("Transforming {} markdown strings into html", strings.size());
        Collection<String> transform = Collections2.transform(strings, new Function<String, String>() {
            @Override
            public String apply(String s) {
                return applyDecorators(s);
            }
        });
        LOGGER.debug("\nInput: \n{}\n\nOutput: \n{}", strings, transform);
        LOGGER.info("Done transforming {} markdown strings into html", strings.size());
        return transform;
    }

    private String applyDecorators(String s) {
        for (LineDecorator ld : decorators) {
            s = ld.decorate(s);
        }
        return s;
    }
}
