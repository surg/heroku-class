package com.yl.maven.decorator;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class HeaderDecoratorTest {
    private HeaderDecorator decorator = new HeaderDecorator();

    @Test
    public void testDecorate() throws Exception {
        // Given
        String input = "# Header 1";
        String expected = "<h1>Header 1</h1>";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testNoDecorate() throws Exception {
        // Given
        String input = "simple line";
        String expected = "<p>simple line</p>";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testH5() throws Exception {
        // Given
        String input = "##### Header 1";
        String expected = "<h5>Header 1</h5>";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

}