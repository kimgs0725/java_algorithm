package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemNo4963 {

    private static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            int w = Integer.parseInt(s[0]), h = Integer.parseInt(s[1]);
            if (w == 0 && h == 0) {
                break;
            }
            int[][] map = new int[h][w];
            boolean[][] check = new boolean[h][w];
            for (int y = 0; y < h; y++) {
                s = br.readLine().split(" ");
                for (int x = 0; x < w; x++) {
                    map[y][x] = Integer.parseInt(s[x]);
                }
            }
            int cnt = 0;
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (map[y][x] == 1 && !check[y][x]) {
                        findLand(y, x, map, check);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    private static void findLand(int y, int x, int[][] map, boolean[][] check) {
        for (int i = 0; i < dy.length; i++) {
            int newy = y + dy[i], newx = x + dx[i];
            if (borderCheck(map, newy, newx) && map[newy][newx] == 1 && !check[newy][newx]) {
                check[newy][newx] = true;
                findLand(newy, newx, map, check);
            }
        }
    }

    private static boolean borderCheck(int[][] map, int newy, int newx) {
        return 0 <= newy && newy < map.length && 0 <= newx && newx < map[0].length;
    }
}
