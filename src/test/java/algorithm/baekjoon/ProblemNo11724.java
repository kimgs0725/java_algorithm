package algorithm.baekjoon;

import java.io.*;

public class ProblemNo11724 {

    private static int N;
    private static int M;
    private static int[][] adj;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        visit = new boolean[N + 1];
        int count = 0;

        for (int i = 1; i < N+1; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }
        bw.write(count + "\n");
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        visit[start] = true;
        for (int i = 1; i < N + 1; i++) {
            if (adj[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

}
