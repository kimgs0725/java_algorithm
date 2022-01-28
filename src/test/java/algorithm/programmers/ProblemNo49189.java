package algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo49189 {

    static boolean connect[][];
    static boolean check[];

    @Test
    void test() {
        assertThat(solution(6, new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        })).isEqualTo(3);
    }

    public int solution(int n, int[][] edge) {
        connect = new boolean[n][n];
        check = new boolean[n];

        for (int[] e: edge) {
            connect[e[0] - 1][e[1] - 1] = true;
            connect[e[1] - 1][e[0] - 1] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;

        return bfs(q, n);
    }

    private int bfs(Queue<Integer> q, int n) {
        int countCity = 0;
        while (!q.isEmpty()) {
            int loop = q.size();
            for (int i = 0; i < loop; i++) {
                int cur = q.poll();
                for (int j = 0; j < n; j++) {
                    if (connect[j][cur] && !check[j]) {
                        check[j] = true;
                        q.add(j);
                    }
                }
            }
            countCity = loop;
        }
        return countCity;
    }
}
