package com.natalio;

import java.util.HashMap;
import java.util.Map;

public class Trie  {
    private Node root;

    public String get(String aWord) {
        Node n = get(root, aWord, 0);

        if(n == null){
            return null;
        }

        return n.word;
    }

    private Node get(Node n, String s, int pos) {
        if (n == null) {
            return null;
        }

        if (pos == s.length()) {
            return n;
        }

        char c = s.charAt(pos);

        return get(n.next.get(c), s, pos + 1);
    }

    public void put(String s) {
        root = put(root, s.toLowerCase(), 0);
    }

    private Node put(Node n, String s, int pos) {
        if (n == null) {
            n = new Node();
        }

        if (pos == s.length()) {
            n.word = s;

            return n;
        }

        char c = s.charAt(pos);
        n.next.put(c, put(n.next.get(c), s, pos + 1));

        return n;
    }

    private static class Node {
        private Map<Character, Node> next = new HashMap<>();
        private String word;
    }
}
