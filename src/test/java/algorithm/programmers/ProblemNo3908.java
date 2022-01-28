package algorithm.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo3908 {

    private static int n, m;

    @Test
    void test() {
        assertThat(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}})).isTrue();
    }

    public boolean solution(int[][] key, int[][] lock) {
        n = key.length;
        m = lock.length;
        int volume = lock.length*3 - 2;
        int[][] map = new int[volume][volume];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                map[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        for (int r = 0; r < 4; r++) {
            for (int y = 0; y < volume - m + 1; y++) {
                for (int x = 0; x < volume - m + 1; x++) {
                    if (isCorrect(y, x, map.length, key, lock)) {
                        return true;
                    }
                }
            }
            key = turnArr(key);
        }
        return false;
    }

    private int[][] turnArr(int[][] key) {
        int[][] clone = new int[n][n];
        for (int i = 0; i < n; i++) {
            int targetI = n - 1;
            for (int j = 0; j < n; j++) {
                clone[i][j] = key[targetI][i];
                targetI--;
            }
        }
        return clone;
    }

    private boolean isCorrect(int n, int m, int length, int[][] key, int[][] lock) {
        int[][] ax = new int[length][length];
        int y = n, x = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ax[y][x++] += key[i][j];
            }
            y++;
            x = m;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ax[i + m - 1][j + m - 1] += lock[i][j];
                if (ax[i + m - 1][j + m - 1] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
