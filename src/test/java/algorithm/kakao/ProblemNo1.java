package algorithm.kakao;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo1 {
    @Test
    void test() {
        assertThat(solution(new int[]{4, 5, 3, 2, 1}, new int[]{2, 4, 4, 5, 1})).isEqualTo(1);
        assertThat(solution(new int[]{5, 4, 5, 4, 5}, new int[]{1, 2, 3, 5, 4})).isEqualTo(3);
    }

    public int solution(int[] gift_cards, int[] wants) {
        Map<Integer, Integer> f = new HashMap<>();
        Map<Integer, Integer> g = new HashMap<>();
        for (int gift_card : gift_cards) {
            if (f.containsKey(gift_card)) {
                Integer integer = f.get(gift_card) + 1;
                f.put(gift_card, integer);
            } else {
                f.put(gift_card, 1);
            }
        }

        for (int want: wants) {
            if (g.containsKey(want)) {
                Integer integer = g.get(want) + 1;
                g.put(want, integer);
            } else {
                g.put(want, 1);
            }
        }

        int sum = 0;
        for (Integer key : f.keySet()) {
            if (g.containsKey(key)) {
                int sub = f.get(key) - g.get(key);
                if (sub > 0) {
                    sum += sub;
                }
            } else {
                sum += f.get(key);
            }
        }
        return sum;
    }
}
