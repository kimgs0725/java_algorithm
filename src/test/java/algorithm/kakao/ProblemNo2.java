package algorithm.kakao;

import org.junit.jupiter.api.Test;

public class ProblemNo2 {
    private int max = 0;

    @Test
    void test() {
        solution(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2);
    }

    public int solution(int[][] needs, int r) {
        int[] need_bit = new int[needs.length];
        for (int i = 0; i < needs.length; i++) {
            int sum = 0, bit = 1;
            for (int j = 0; j < needs[i].length; j++) {
                if (needs[i][j] == 1) {
                    sum |= bit;
                }
                bit <<= 1;
            }
            need_bit[i] = sum;
        }
        int bit = 0;
        f(need_bit, r, bit, needs[0].length);
        return max;
    }

    private void f(int[] needs, int r, int bit, int a) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < needs.length; i++) {
                sum += (~(needs[i] ^ bit) != 0) ? 1 : 0;
            }
            max = Math.max(max, sum);
            return;
        }
        int b = 1;
        for (int i = 0; i < a; i++) {
            if ((bit & b) == 0) {
                bit |= b;
                f(needs, r - 1, bit, a);
                bit ^= b;
            }
            b <<= 1;
        }
    }
}
