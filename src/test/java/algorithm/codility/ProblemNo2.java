package algorithm.codility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo2 {

    @Test
    void test() {
        assertThat(solution("23")).isEqualTo(7);
        assertThat(solution("0081")).isEqualTo(11);
        assertThat(solution("022")).isEqualTo(9);
    }

    public int solution(String S) {
        // S 내 숫자들중 하나를 바꿨을 떄, 3으로 나누어지는 숫자들이 몇개??
        // 각 자릿수의 합을 더한 뒤 3으로 나누면 어떨까??
        int sum = 0;
        for (char c : S.toCharArray()) {
            sum += (c - '0');
        }
        int count = (sum % 3 == 0 ? 1 : 0);
        for (int i = 0; i < S.length(); i++) {
            int except_num = S.charAt(i) - '0';
            sum -= except_num;
            for (int j = 0; j < 10; j++) {
                if (j != except_num) {
                    count += ((sum + j) % 3 == 0 ? 1 : 0);
                }
            }
            sum += (S.charAt(i) - '0');
        }
        return count;
    }
}
