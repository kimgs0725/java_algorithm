package algorithm.scf;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo1 {

    @Test
    void test() {
    }

    private String findUsingTime(String[][] starttime, String[][] endtime) {
        String[] minTime = findMinTime(starttime);
        String[] maxTime = findMaxTime(endtime);
        if (compareTimezone(minTime, maxTime)) {
            return minTime + " ~ " + maxTime;
        }
        return "-1";
    }

    private String[] findMinTime(String[][] timezone) {
        String[] minTime = timezone[0];
        for (int i = 1; i < timezone.length; i++) {
            if (compareTimezone(minTime, timezone[i])) {
                minTime = timezone[i];
            }
        }
        return minTime;
    }

    private String[] findMaxTime(String[][] timezone) {
        String[] maxTime = timezone[0];
        for (int i = 1; i < timezone.length; i++) {
            if (!compareTimezone(maxTime, timezone[i])) {
                maxTime = timezone[i];
            }
        }
        return maxTime;
    }

    private boolean compareTimezone(String[] timezone1, String[] timezone2) {
        if (timezone1[0].compareTo(timezone2[0]) == 0) {
            return timezone1[1].compareTo(timezone2[1]) < 0;
        }
        return timezone1[0].compareTo(timezone2[0]) < 0;
    }
}
