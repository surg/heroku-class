package com.yl.maven;

import java.util.Collection;

public interface MarkdownParser {
    Collection<String> parse(Collection<String> strings);
}
