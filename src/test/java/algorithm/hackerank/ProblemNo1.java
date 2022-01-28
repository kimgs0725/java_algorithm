package algorithm.hackerank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class ProblemNo1 {

    @Test
    void test() {
        assertThat(deviceNamesSystem(Arrays.asList("mixer","toaster","mixer","tv"))).containsExactly("mixer", "toaster", "mixer1", "tv");
    }

    public List<String> deviceNamesSystem(List<String> devicenames) {
        Map<String, Integer> freqDeviceName = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String devicename : devicenames) {
            freqDeviceName.put(devicename, freqDeviceName.getOrDefault(devicename, -1) + 1);
            if (freqDeviceName.get(devicename) == 0) {
                ans.add(devicename);
            } else {
                StringBuilder sb = new StringBuilder();
                ans.add(sb.append(devicename).append(freqDeviceName.get(devicename)).toString());
            }
        }
        return ans;
    }
}
