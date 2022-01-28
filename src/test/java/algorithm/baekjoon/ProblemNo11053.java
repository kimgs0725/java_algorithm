package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemNo11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), max = 1;
        String[] s = br.readLine().split(" ");
        int[] nums = new int[n];
        int[] cache = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
            cache[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && cache[i] < cache[j] + 1) {
                    cache[i] = cache[j] + 1;
                }
            }
            max = Math.max(max, cache[i]);
        }
        System.out.println(max);
    }
}
