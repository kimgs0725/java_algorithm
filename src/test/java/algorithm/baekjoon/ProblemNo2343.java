package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemNo2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        int left = 0, right = 0, answer = 0;
        int[] num = new int[n];
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(str[i]);
            left = Math.max(left, num[i]);
            right += num[i];
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int sum = 0, cnt = 0;
            for (int i = 0; i < n; i++) {
                if (sum + num[i] >= mid) {
                    cnt++;
                    sum = 0;
                }
                sum += num[i];
            }
            cnt += (sum > 0 ? 1 : 0);
            if (cnt <= m) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
