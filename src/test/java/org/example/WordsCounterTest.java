package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class WordsCounterTest {

    @Test
    public void testTopKFrequent() {
        assertEquals(
                Arrays.asList("a", "i"),
                Arrays.asList(WordsCounter.topKFrequent_v3(new String[]{"a", "a", "i", "love", "ing", "i", "love", "coding"}, 2)));

        assertEquals(
                Arrays.asList("the", "is", "sunny", "day"),
                Arrays.asList(WordsCounter.topKFrequent_v3(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)));
    }
}
