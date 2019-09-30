package com.udacity.examples.Testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HelperTest {

    @BeforeClass
    public static void initClass() {
        System.out.println("BeforeClass executed");
    }

    @AfterClass
    public static void teardownClass() {
        System.out.println("AfterClass executed");
    }

    @Before
    public void init() {
        System.out.println("Before executed");
    }

    @After
    public void teardown() {
        System.out.println("After executed");
    }

    @Test
    public void test() {
        assertEquals("verifying assert equals", "test", "test");
    }

    @Test
    public void validate_getCount() {
        List<String> empNames = Arrays.asList("test1", "", "test2", "");
        assertEquals("test number of non empty strings", 2, Helper.getCount(empNames));
    }

    @Test
    public void verify_list_is_squared() {
        List<Integer> yrsOfExperience = Arrays.asList(13, 4, 15, 6, 17, 8, 19, 1, 2, 3);
        List<Integer> expected = Arrays.asList(169, 16, 225, 36, 289, 64, 361, 1, 4, 9);
        assertEquals("test square", expected, Helper.getSquareList(yrsOfExperience));
    }

    @Test
    public void merged_list() {
        List<String> empNames = Arrays.asList("sareeta", "", "john", "");
        assertEquals("test merge list", "sareeta, john", Helper.getMergedList(empNames));
    }

    @Test
    public void getMax() {
        List<Integer> empLevel = Arrays.asList(3, 3, 3, 5, 7, 2, 2, 5, 7, 5);
        assertEquals(7, Helper.getStats(empLevel).getMax());
    }
}
