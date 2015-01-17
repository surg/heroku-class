package com.yl.maven;

import com.google.common.io.CharStreams;
import org.testng.annotations.Test;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

public class MarkdownParserTest {

    private MarkdownParser parser = new MarkdownParserFactory().createParser();

    @Test
    public void testParse() throws Exception {
        Collection<String> input = CharStreams.readLines(new InputStreamReader(getClass().getResourceAsStream("/sample.txt")));
        Collection<String> expected = CharStreams.readLines(new InputStreamReader(getClass().getResourceAsStream("/expected.txt")));

        Collection<String> actual = new ArrayList<>(parser.parse(input));

        assertThat(actual).isEqualTo(expected);
    }
}