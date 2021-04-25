package algorithm.kakao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProblemNo3 {

    private int end_node = -1;
    private int ans_sum = 0;

    @Test
    void test() {
        int[] solution = solution(6, new int[]{1, 1, 1, 1, 1, 1}, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}});
        System.out.println("solution[0] = " + solution[0]);
        System.out.println("solution[1] = " + solution[1]);
    }

    public int[] solution(int n, int[] passenger, int[][] train) {
        int sum = 0;
        int[][] g = new int[n+1][n+1];
        for (int i = 0; i < train.length; i++) {
            g[train[i][0]][train[i][1]] = passenger[train[i][0]-1];
        }
        dfs(n, 1, g, passenger, sum);
        return new int[]{end_node, ans_sum};
    }

    private void dfs(int n, int node, int[][] g, int[] passenger, int sum) {
        boolean is_end_node = true;
        for (int i = 0; i <= n; i++) {
            if (g[node][i] != 0) {
                is_end_node = false;
                dfs(n, i, g, passenger, sum + g[node][i]);
            }
        }
        if (is_end_node) {
            sum += passenger[node-1];
            if (ans_sum < sum) {
                ans_sum = sum;
                end_node = node;
            } else if (ans_sum == sum) {
                end_node = Math.max(node, end_node);
            }
        }
    }
}
