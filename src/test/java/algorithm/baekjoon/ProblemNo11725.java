package algorithm.baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ProblemNo11725 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> node = new ArrayList<ArrayList<Integer>>();
        int[] parents = new int[N+1];
        for (int i = 0; i <= N + 1; i++) {
            node.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node.get(a).add(b);
            node.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        parents[1] = 1;
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int item : node.get(parent)) {
                if (parents[item] == 0) {
                    parents[item] = parent;
                    queue.offer(item);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
