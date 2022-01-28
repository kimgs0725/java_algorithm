package algorithm.baekjoon;

import java.io.*;
import java.util.Arrays;

public class ProblemNo2098 {

    private static final int INF = 16 * 1_000_000;
    static int n;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][(1 << n) - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        bw.write(tsp(0, 1) + "\n");
        bw.close();
        br.close();
    }

    private static int tsp(int node, int visit) {
        if (visit == (1 << n) - 1) {
            if (arr[node][0] == 0) return INF;
            return arr[node][0];
        }

        if (dp[node][visit] != INF) {
            return dp[node][visit];
        }

        for (int i = 0; i < n; i++) {
            int next = visit | (1 << i);
            if (arr[node][i] == 0 || (visit & (1 << i)) != 0)
                continue;
            dp[node][visit] = Math.min(dp[node][visit], tsp(i, next) + arr[node][i]);
        }
        return dp[node][visit];
    }
}
