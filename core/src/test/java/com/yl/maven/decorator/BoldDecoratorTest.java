package com.yl.maven.decorator;

import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class BoldDecoratorTest {
    private BoldDecorator decorator = new BoldDecorator();
    @Test
    public void testDecorate() throws Exception {
        // Given
        String input = "Contains **bold** text";
        String expected = "Contains <strong>bold</strong> text";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testNotEnough() throws Exception {
        // Given
        String input = "No a bold ** text";

        // When
        String actual = decorator.decorate(input);

        // Then
        assertThat(actual).isEqualTo(input);
    }


}