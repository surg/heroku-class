package com.yl.maven;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class MarkdownMain {
    public static void main(String[] args) throws IOException {
        Params params = new Params();
        new JCommander(params, args);

        MarkdownParser parser = new MarkdownParserFactory().createParser();
        Collection<String> lines = Files.readLines(new File(params.inputFile), Charsets.UTF_8);
        Collection<String> result = parser.parse(lines);
        String fin = Joiner.on("\n").join(result);

        if (params.outputFile != null) {
            Files.write(fin, new File(params.outputFile), Charsets.UTF_8);
        } else {
            System.out.println(fin);
        }
    }
}

class Params {
    @Parameter(names = "--in", required = true, description = "Input file")
    public String inputFile;

    @Parameter(names = "--out", description = "Output file")
    public String outputFile;
}
