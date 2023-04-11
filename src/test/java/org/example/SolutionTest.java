package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testTopKFrequent() {
        assertEquals(
                Arrays.asList("a", "i"),
                Arrays.asList(Solution.topKFrequent_v3(new String[]{"a", "a", "i", "love", "ing", "i", "love", "coding"}, 2)));

        assertEquals(
                Arrays.asList("the", "is", "sunny", "day"),
                Arrays.asList(Solution.topKFrequent_v3(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)));
    }
}
