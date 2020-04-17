package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-word-in-dictionary
 */
public class Longest_Word_in_Dictionary {
    public static void main(String[] args) {
        String [] words = new String[] { "w","wo","wor","worl", "world", "worlc" };
        Longest_Word_in_Dictionary entity = new Longest_Word_in_Dictionary();
        System.out.println(entity.longestWord(words));
    }

    // sort
    // time: O(n log n) as there's sort, which is for average is O(n log n)
    // space: O(n) as we define the code
    public String longestWord(String[] words) {
        // sort by length ascending order, sort by lexicographical descending order, thus the later one is the longest word but lexicaographically smallest
        Arrays.sort(words, (o1, o2) -> {
            if(o1.length() == o2.length()){
                return  o2.compareTo(o1);
            }
            return Integer.compare(o1.length(),o2.length());
        });

        String out = "";
        Set<String> prefixes = new HashSet<>();
        for (String word : words) {
            // single char or it contains current word's substring (exclude last char)
            if(word.length() ==1 || prefixes.contains(word.substring(0,word.length()-1)) ){
                // add word
                prefixes.add(word);
                // get longest.
                if(out.length() <= word.length()) {
                    out = word;
                }
            }
        }
        return out;
    }
}
