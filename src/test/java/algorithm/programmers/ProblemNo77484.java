package algorithm.programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo77484 {

    @Test
    void test() {
        assertThat(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19})).containsExactlyInAnyOrder(3, 5);
        assertThat(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25})).containsExactlyInAnyOrder(1, 6);
        assertThat(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35})).containsExactlyInAnyOrder(1, 1);
        assertThat(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{2, 19, 13, 43, 42, 5})).containsExactlyInAnyOrder(6, 6);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int correct_num = 0, wrong_num = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                wrong_num++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    correct_num++;
                    break;
                }
            }
        }
        if (wrong_num == 6) {
            return new int[]{1, 6};
        } else if (wrong_num == 0 && correct_num == 0) {
            return new int[]{6, 6};
        }
        return new int[]{7 - (correct_num + wrong_num), 7 - (correct_num)};
    }
}
