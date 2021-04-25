package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo200 {

    @Test
    void test() {
        assertThat(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        })).isEqualTo(1);
        assertThat(numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        })).isEqualTo(3);
    }

    private static final int[] dy = new int[]{-1, 0, 1, 0};
    private static final int[] dx = new int[]{0, 1, 0, -1};
    private int numIslands(char[][] grid) {
        boolean[][] is_visit = new boolean[grid.length][grid[0].length];
        int m = grid.length, n = grid[0].length, count = 0;
        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (grid[y][x] == '1' && !is_visit[y][x]) {
                    findIsland(grid, is_visit, y, x);
                    count++;
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid, boolean[][] is_visit, int y, int x) {
        is_visit[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int yy = y + dy[i], xx = x + dx[i];
            if (0 > yy || yy >= grid.length || 0 > xx || xx >= grid[0].length) {
                continue;
            }
            if (grid[yy][xx] == '1' && !is_visit[yy][xx]) {
                findIsland(grid, is_visit, yy, xx);
            }
        }
    }
}
