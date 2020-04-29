package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-morse-code-words/
 */
public class Unique_Morse_Code_Words {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> unique_codes = new HashSet<>();

        // define MORSE code
        String[] MORSE = new String[]{};

        for (String word : words) {
            StringBuilder transformation = new StringBuilder();
            for (char c : word.toCharArray()) {
                transformation.append(MORSE[c - 'a']);
            }

            unique_codes.add(transformation.toString());
        }

        return unique_codes.size();
    }
}
