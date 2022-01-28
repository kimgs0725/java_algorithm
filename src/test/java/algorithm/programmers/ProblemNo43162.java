package algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo43162 {

    private boolean[][] check = new boolean[200][200];

    @Test
    void test() {
        assertThat(solution(3, new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        })).isEqualTo(2);
        assertThat(solution(3, new int[][]{
                {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
        })).isEqualTo(1);
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                bfs(i, n, computers, check);
                answer++;
            }
        }
        return answer;
    }

    private void bfs(int i, int n, int[][] computers, boolean[] check) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while (!q.isEmpty()) {
            int curIndex = q.poll();
            check[curIndex] = true;
            for (int k = 0; k < n; k++) {
                if (!check[k] && computers[curIndex][k] == 1) {
                    q.offer(k);
                }
            }
        }
    }
}
