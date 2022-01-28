package algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemNo1504 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n, e, v1, v2;
    private static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[] startDist = dijkstra(1);
        int[] v1Dist = dijkstra(v1);
        int[] v2Dist = dijkstra(v2);
        long ret1 = (long)startDist[v1] + (long)v1Dist[v2] + (long)v2Dist[n];
        long ret2 = (long)startDist[v2] + (long)v2Dist[v1] + (long)v1Dist[n];
        long ans = Math.min(ret1, ret2);
        if (ans >= Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            bw.write(ans + "\n");
        }
        bw.close();
        br.close();
    }

    private static int[] dijkstra(int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean visited[] = new boolean[n + 1];
        dist[v] = 0;
        pq.offer(new Node(v, 0));
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
