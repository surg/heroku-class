package com.yl.maven.web;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.yl.maven.MarkdownParser;
import com.yl.maven.MarkdownParserFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Collection;

@Path("/")
public class MarkdownResource {
    private MarkdownParser parser = new MarkdownParserFactory().createParser();

    @POST
    public String parse(String input) {
        Iterable<String> lines = Splitter.on('\n').split(input);
        Collection<String> result = parser.parse(Lists.newArrayList(lines));
        return Joiner.on('\n').join(result);
    }
}
