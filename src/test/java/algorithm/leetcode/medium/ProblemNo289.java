package algorithm.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProblemNo289 {

    @Test
    void test() {
        int[][] board = new int[][]{
            {0,1,0},
            {0,0,1},
            {1,1,1},
            {0,0,0}
        };
        gameOfLife(board);
    }

    private void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                int liveCell = countLiveCell(board, y, x);
                if (liveCell < 2) {
                    newBoard[y][x] = 0;
                } else if (liveCell == 2 || liveCell == 3) {
                    if (board[y][x] == 1) {
                        newBoard[y][x] = 1;
                    } else if (board[y][x] == 0 && liveCell == 3) {
                        newBoard[y][x] = 1;
                    }
                } else if (liveCell > 3) {
                    if (board[y][x] == 1) {
                        newBoard[y][x] = 0;
                    }
                }
            }
        }
        board = newBoard;
    }

    private int countLiveCell(int[][] board, int y, int x) {
        int[] dy = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dx = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int count = 0;
        for (int i = 0; i < dy.length; i++) {
            int newY = y + dy[i], newX = x + dx[i];
            if (0 > newY || newY >= board.length || 0 > newX || newX >= board[0].length) {
                continue;
            }
            count += board[newY][newX];
        }
        return count;
    }
}
