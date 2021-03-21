package algorithm.scf;

public class ProblemNo6 {

    int getManyClothes(int n, int m, int[][] clothes) {
        int[][] f = new int[n+1][m+1];
        f[1][1] = clothes[0][0];
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                f[y][x] = clothes[y-1][x-1] + Math.max(f[y-1][x], f[y][x-1]);
            }
        }
        return f[n][m];
    }
}
