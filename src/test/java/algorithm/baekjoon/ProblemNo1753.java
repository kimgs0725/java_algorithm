package algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemNo1753 {

    private static int v, e, k;
    private static ArrayList<Node> list[];
    private static int dist[];
    private static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        dist = new int[v +1];
        list = new ArrayList[v +1];
        visited = new boolean[v +1];
        for (int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        k = Integer.parseInt(br.readLine());
        dist[k] = 0;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
        }
        dijkstra();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra() {
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
                    pq.add(new Node(o.idx, dist[o.idx]));
                }
            }
        }
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
