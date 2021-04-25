package algorithm.scf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem2No3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node());
        }
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            Node parent = nodes.get(p-1);
            Node child = nodes.get(c-1);
            child.parent = parent;
        }
        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            if (p == c) {
                System.out.println("no");
            }
            Node parentNode = nodes.get(p-1);
            Node currNode = nodes.get(c-1);
            while (currNode != null) {
                if (currNode == parentNode) {
                    break;
                }
                currNode = currNode.parent;
            }
            if (currNode == null) {
                System.out.println("no");
            } else {
                System.out.println("yes");
            }
        }
        String s = "sadfas";
        
    }

    static class Node {
        Node parent = null;
        public Node() {}
    }
}
