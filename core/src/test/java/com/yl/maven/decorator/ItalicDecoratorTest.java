package com.yl.maven.decorator;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ItalicDecoratorTest {
    private ItalicDecorator decorator = new ItalicDecorator();

    @Test
    public void testDecorate() throws Exception {
        // Given
        String input = "Contains *italic* text";
        String expected = "Contains <em>italic</em> text";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDecorateStart() throws Exception {
        // Given
        String input = "*starts italic* text";
        String expected = "<em>starts italic</em> text";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDecorateMulti() throws Exception {
        // Given
        String input = "*multiple* instances of *italic* text";
        String expected = "<em>multiple</em> instances of <em>italic</em> text";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSkipBold() throws Exception {
        // Given
        String input = "Contains **bold** text";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(input);
    }

}