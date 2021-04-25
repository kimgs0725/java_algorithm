package algorithm.algo;

import com.sun.tools.javac.util.Pair;

import java.util.*;

public class AhocorasickAlgo {

    List<Pair<Integer, Integer>> ahoCorasick(String s, TrieNode root) {
        List<Pair<Integer, Integer>> ret = new ArrayList<>();
        TrieNode state = root;
        for (int i = 0; i < s.length(); i++) {
            int chr = toNumber(s.charAt(i));
            while (state != root && state.children[chr] == null) {
                state = state.fail;
            }
            if (state.children[chr] != null) {
                state = state.children[chr];
            }
            for (Integer j : state.output) {
                ret.add(new Pair<>(i, j));
            }
        }
        return ret;
    }

    void computeFailFunc(TrieNode root) {
        Queue<TrieNode> q = new LinkedList<>();
        root.fail = root;
        q.add(root);
        while (!q.isEmpty()) {
            TrieNode here = q.poll();
            for (int edge = 0; edge < 26; edge++) {
                TrieNode child = here.children[edge];
                if (child == null) continue;
                if (here == root) {
                    child.fail = root;
                } else {
                    TrieNode t = here.fail;
                    while (t != root && t.children[edge] == null) {
                        t = t.fail;
                    }
                    if (t.children[edge] != null) {
                        t = t.children[edge];
                    }
                    child.fail = t;
                }
                child.output = child.fail.output;
                if (child.terminal != -1) {
                    child.output.add(child.terminal);
                }
                q.add(child);
            }
        }
    }

    private static int toNumber(char ch) { return ch - 'a'; }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public TrieNode fail;
        public int terminal;
        Set<Integer> output = new HashSet<>();

        public void insert(String s) {
            insert(new StringBuilder(s), 0);
        }

        public boolean contains(String s) {
            return find(new StringBuilder(s), 0) != null;
        }

        private void insert(StringBuilder s, int index) {
            if (s.length() == index) {
            } else {
                int next = toNumber(s.charAt(index));
                if (children[next] == null) {
                    children[next] = new TrieNode();
                }
                children[next].insert(s, index + 1);
            }
        }

        TrieNode find(StringBuilder s, int index) {
            if (index == s.length()) {
                return this;
            }
            int next = toNumber(s.charAt(index));
            if (children[next] == null) {
                return null;
            }
            return children[next].find(s, index + 1);
        }
    }
}