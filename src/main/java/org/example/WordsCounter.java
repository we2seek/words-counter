package org.example;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 */
public class WordsCounter {
    static class Frequency {
        int value;

        Frequency(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Frequency.class.getSimpleName() + "[", "]")
                    .add("value=" + value)
                    .toString();
        }
    }

    /**
     * Find most frequent K words.
     * Version 1: Use Map.contains in getOrDefault
     *
     * @param words Source words
     * @param k     How many TOP words should be in result
     * @return TOP K most frequent words
     */
    public static String[] topKFrequent_v1(String[] words, int k) {
        // Create a map to store the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Create a list of the entries in the map, sorted by frequency and then by lexicographical order
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp != 0) {
                return cmp;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        // Create an array of the top k most frequent words
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }

    /**
     * Find most frequent K words.
     * Version 2: Do not use Map.contains, but may be still slow
     *
     * @param words Source words
     * @param k     How many TOP words should be in result
     * @return TOP K most frequent words
     */
    public static String[] topKFrequent_v2(String[] words, int k) {
        // Create a map to store the frequency of each word
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            Integer frequency = (frequency = freqMap.get(word)) == null ? 1 : frequency + 1;
            freqMap.put(word, frequency);
        }

        // Create a list of the entries in the map, sorted by frequency and then by lexicographical order
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> {
            int cmp = b.getValue().compareTo(a.getValue());
            if (cmp != 0) {
                return cmp;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        // Create an array of the top k most frequent words
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }

    /**
     * Find most frequent K words.
     * Version 2: Do not use Map.contains
     *
     * @param words Source words
     * @param k     How many TOP words should be in result
     * @return TOP K most frequent words
     */
    public static String[] topKFrequent_v3(String[] words, int k) {
        // Create a map to store the frequency of each word
        Map<String, Frequency> freqMap = new HashMap<>();
        for (String word : words) {
            Frequency freq = new Frequency(1);
            Frequency freqPrev = freqMap.put(word, freq);
            if (freqPrev != null) {
                freq.value = freqPrev.value + 1;
            }
        }

        // Create a list of the entries in the map, sorted by frequency and then by lexicographical order
        List<Map.Entry<String, Frequency>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a, b) -> {
            int cmp = b.getValue().value - a.getValue().value;
            if (cmp != 0) {
                return cmp;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });

        // Create an array of the top k most frequent words
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = entries.get(i).getKey();
        }

        return result;
    }
}