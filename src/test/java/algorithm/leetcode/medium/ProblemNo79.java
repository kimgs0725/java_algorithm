package algorithm.leetcode.medium;

public class ProblemNo79 {

    private boolean visited[][] = new boolean[6][6];
    private int[] dy = {-1, 0, 1, 0};
    private int[] dx = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        for (int y = 0; y < 6; y++) {
            for (int x = 0; x < 6; x++) {
                if (search(board, y, x, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int y, int x, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }
        char c = word.charAt(idx);
        for (int i = 0; i < 4; i++) {
            int newy = y + dy[i], newx = x + dx[i];
            if (0 <= newy && newy < board.length &&
                0 <= newx && newx < board[0].length &&
                !visited[newy][newx] && c == board[newy][newx]) {
                visited[newy][newx] = true;
                boolean ret = search(board, newy, newx, word, idx + 1);
                visited[newy][newx] = false;
                if (ret) {
                    return true;
                }
            }
        }
        return false;
    }
}
