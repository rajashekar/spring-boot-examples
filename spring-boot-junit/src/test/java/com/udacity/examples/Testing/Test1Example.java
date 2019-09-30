package com.udacity.examples.Testing;

import org.junit.Test;

import junit.framework.TestCase;

public class Test1Example extends TestCase {
    @Test
    public void test() {
        assertEquals("verifying assert equals", "test", "test");
    }
}
