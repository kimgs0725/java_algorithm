package algorithm.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemNo6603 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int k;
    private static boolean[] skip;
    private static int[] num;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(input, " ");
            k = Integer.parseInt(st.nextToken());
            num = new int[k];
            skip = new boolean[k];
            for (int i = 0; i < k; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0, 0, sb);
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void lotto(int line, int count, StringBuilder sb) {
        if (count == 6) {
            for (int i = 0; i < k; i++) {
                if (skip[i]) {
                    sb.append(num[i]).append(' ');
                }
            }
            sb.append('\n');
        }

        for (int j = line; j < k; j++) {
            skip[j] = true;
            lotto(j + 1, count + 1, sb);
            skip[j] = false;
        }
    }
}
