package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ProblemNo7576 {

    private static int m, n;
    private static final int[] dy = new int[]{-1, 0, 1, 0};
    private static final int[] dx = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);
        int[][] tomato = new int[n][m];
        Queue<Coordinate> queue = new LinkedList<>();
        for (int y = 0; y < n; y++) {
            String[] line = br.readLine().split(" ");
            for (int x = 0; x < m; x++) {
                tomato[y][x] = Integer.parseInt(line[x]);
                if (tomato[y][x] == 1) {
                    queue.offer(new Coordinate(y, x));
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = curr.getY() + dy[i];
                int nx = curr.getX() + dx[i];
                if (isInside(ny, nx) && tomato[ny][nx] == 0) {
                    tomato[ny][nx] = tomato[curr.getY()][curr.getX()] + 1;
                    queue.offer(new Coordinate(ny, nx));
                }
            }
        }

        int days = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (tomato[y][x] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, tomato[y][x]);
                System.out.print(tomato[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println(days - 1);
    }

    private static boolean isInside(int ny, int nx) {
        return 0 <= ny && ny < n && 0 <= nx && nx < m;
    }

    static class Coordinate {
        private int y;
        private int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
