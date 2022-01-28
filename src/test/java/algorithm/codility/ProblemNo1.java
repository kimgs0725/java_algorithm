package algorithm.codility;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo1 {

    @Test
    void test() {
        assertThat(solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3})).isEqualTo("SUMMER");
        assertThat(solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -18})).isEqualTo("AUTUMN");
    }

    public String solution(int[] T) {
        int len = T.length;
        Map<Integer, String> mapToSeason = new HashMap<>();
        mapToSeason.put(0, "WINTER");
        mapToSeason.put(1, "SPRING");
        mapToSeason.put(2, "SUMMER");
        mapToSeason.put(3, "AUTUMN");
        int highestAmp = -1, highestAmpInd = 0;
        for (int i = 0; i < 4; i++) {
            int start = i * (len / 4), end = (i + 1) * (len / 4);
            int max = -1001, min = 1001;
            while (start < end) {
                max = Math.max(max, T[start]);
                min = Math.min(min, T[start]);
                start++;
            }
            if (highestAmp < (max - min)) {
                highestAmp = (max - min);
                highestAmpInd = i;
            }
        }
        return mapToSeason.get(highestAmpInd);
    }
}
