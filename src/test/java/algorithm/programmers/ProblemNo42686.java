package algorithm.programmers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo42686 {

    @Test
    void test() {
        assertThat(solution(5, new int[]{2, 4}, new int[]{1, 3, 5})).isEqualTo(5);
        assertThat(solution(5, new int[]{2, 4}, new int[]{3})).isEqualTo(4);
        assertThat(solution(5, new int[]{2,3,4}, new int[]{1,5})).isEqualTo(4);
        assertThat(solution(1, new int[]{1}, new int[]{})).isEqualTo(0);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        if (lost.length == 0) {
            return n;
        }
        int answer = 0;
        int[] student = new int[n];
        Arrays.fill(student, 1);
        for (int i = 0; i < lost.length; i++) {
            student[lost[i] - 1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i] - 1]++;
        }
        for (int i = 0; i < n; i++) {
            if (student[i] == 0) {
                if (i < n-1 && student[i+1] == 2) {
                    student[i+1] = 1;
                    student[i] = 1;
                    answer++;
                } else if (i > 0 && student[i-1] == 2) {
                    student[i-1] = 1;
                    student[i] = 1;
                    answer++;
                }
            } else if (student[i] >= 1) {
                answer++;
            }
        }
        return answer;
    }
}
