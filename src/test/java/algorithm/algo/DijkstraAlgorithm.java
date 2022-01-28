package algorithm.algo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.*;

public class DijkstraAlgorithm {

    @Test
    void test() {
        assertThat(dijkstra(5, 6, 1, new String[]{"5 1 1", "1 2 2", "1 3 3", "2 3 4", "2 4 5", "3 4 6"})).contains(0, 2, 3, 7, Integer.MAX_VALUE);
    }

    private int[] dijkstra(int v, int e, int k, String[] node) {
        int dist[] = new int[v + 1];
        boolean visited[] = new boolean[v + 1];
        ArrayList<Node>[] list = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(node[i], " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
        }

        dist[k] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(k, 0));
        while (!pq.isEmpty()) {
            Node a = pq.poll();
            if (visited[a.idx]) {
                continue;
            }
            visited[a.idx] = true;
            for (Node o : list[a.idx]) {
                if (dist[o.idx] > dist[a.idx] + o.weight) {
                    dist[o.idx] = dist[a.idx] + o.weight;
                    pq.offer(new Node(o.idx, dist[o.idx]));
                }
            }
        }
        return dist;
    }

    static class Node implements Comparable<Node> {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
