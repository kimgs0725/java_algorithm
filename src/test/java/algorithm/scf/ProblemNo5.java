package algorithm.scf;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProblemNo5 {

    @Test
    void test() {

    }

    private int findFastestPath(int n, int m, char[][] path) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (path[0][i] == 'c') {
                int cnt = 0;
                Node standardPath = findStandardPath(0, i, path, n, m);
                Node curr = standardPath;
                while (curr == null) {
                    Node prev = curr.prev;
                    cnt += prev.x != curr.x ? 1 : 0;
                }
                min = Math.min(min, cnt);
            }
        }
        return min;
    }

    private Node findStandardPath(int y, int x, char[][] path, int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        int[] dist_y = {1, 0, 0};
        int[] dist_x = {0, -1, 1};
        boolean[][] visited = new boolean[n][m];
        visited[y][x] = true;
        queue.offer(new Node(y, x, null));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.y == m - 1) {
                return node;
            }
            for (int i = 0; i < 3; i++) {
                int vy = node.y + dist_y[i];
                int vx = node.x + dist_x[i];
                if (0 < vy && vy < m && 0 < vx && vx < n && !visited[vy][vx] && path[vy][vx] == '.') {
                    visited[vy][vx] = true;
                    queue.offer(new Node(vy, vx, node));
                }
            }
        }
        return null;
    }
}

class Node{
    int y;
    int x;
    Node prev;

    public Node(int y, int x, Node prev) {
        this.y = y;
        this.x = x;
        this.prev = prev;
    }
}
