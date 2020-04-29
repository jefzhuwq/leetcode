package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Design Auto Complete System
 * idea: trie
 */
public class Design_Auto_Complete_System {

    /**
     * TrieNode class
     */
    class TrieNode implements Comparable<TrieNode> {
        TrieNode[] children; // list of TrieNode children
        String s;
        int times; // how many times it's been searched before.
        List<TrieNode> hot; // hot list, no moe than 3 elements.

        public TrieNode() {
            children = new TrieNode[128];
            s = null;
            times = 0;
            hot = new ArrayList<>();
        }

        public int compareTo(TrieNode o) {
            // if the same number of times, compare the ascii code
            if (this.times == o.times) {
                return this.s.compareTo(o.s);
            }
            // otherwise, compare number of times (higher number of times should be higher rank)
            return o.times - this.times;
        }

        /**
         * Update Trie (add to hot list, and then remove last one if more than 3)
         *
         * @param node
         */
        public void update(TrieNode node) {
            if (!this.hot.contains(node)) {
                this.hot.add(node);
            }

            Collections.sort(hot);
            if (hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;

    /**
     * Constructor for initialize candidate strings and frequencies
     * @param sentences
     * @param times
     */
    public Design_Auto_Complete_System(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        // add sentences to list
        for (int i = 0; i < times.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    /**
     * Add string to Trie tree
     * @param sentence: this is the sentence input so far
     * @param times
     */
    public void add(String sentence, int times) {
        TrieNode tmp = root;
        List<TrieNode> list = new ArrayList<>();
        // loop all chars in sentences
        for (char c : sentence.toCharArray()) {
            // it's a new char, which doesn't exist in the trie, then create a new one
            if (tmp.children[c] == null) {
                tmp.children[c] = new TrieNode();
            }

            tmp = tmp.children[c];
            list.add(tmp);
        }

        tmp.s = sentence;
        tmp.times += times;

        for (TrieNode node : list) {
            node.update(tmp);
        }
    }


    /**
     * Input the c, at the same time return the possible candidate strings
     *
     * @param c
     * @return
     */
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        // it's end of the input
        if (c == '#') {
            add(sb.toString(), 1);
            sb = new StringBuilder();
            cur = root;
            return result;
        }

        sb.append(c);
        // move to children if cur exists
        if (cur != null) {
            cur = cur.children[c];
        }

        // if cur is null, which mean can't find, return result (which is an empty list of string, means nothing found)
        if (cur == null) {
            return result;
        }

        // add result 
        for (TrieNode node : cur.hot) {
            result.add(node.s);
        }

        return result;
    }
}
