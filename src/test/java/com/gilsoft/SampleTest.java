package com.gilsoft;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SampleTest {
    @Test
    public void shouldTestSomethingRandom() {
        assertThat(true, is(true));
    }
}
