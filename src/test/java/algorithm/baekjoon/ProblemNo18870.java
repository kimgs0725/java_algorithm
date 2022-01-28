package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProblemNo18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String[] x = buffer.readLine().split(" ");
        int[] nums = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            nums[i] = Integer.parseInt(x[i]);
        }
        int[] sorted_nums = nums.clone();
        Arrays.sort(sorted_nums);

        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : sorted_nums) {
            if (!freq.containsKey(n)) {
                freq.put(n, count++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : nums) {
            sb.append(freq.get(n)).append(' ');
        }
        System.out.println(sb.toString());
    }
}
