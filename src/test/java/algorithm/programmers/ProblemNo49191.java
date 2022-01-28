package algorithm.programmers;

public class ProblemNo49191 {

    public int solution(int n, int[][] results) {
        int INF = 100001, answer = 0;
        boolean[][] check = new boolean[n+1][n+1];

        for (int[] arr : results) {
            check[arr[0]][arr[1]] = true;
        }

        for (int k = 1; k < check.length; k++) {
            for (int i = 1; i < check.length; i++) {
                for (int j = 1; j < check.length; j++) {
                    if (i != j && check[i][k] && check[k][j]) {
                        check[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i < check.length; i++) {
            boolean pass = true;
            for (int j = 1; j < check[i].length; j++) {
                if (i != j && !(check[i][j] || check[j][i])) {
                    pass = false;
                    break;
                }
            }
            answer += (pass ? 1 : 0);
        }
        return answer;
    }
}
