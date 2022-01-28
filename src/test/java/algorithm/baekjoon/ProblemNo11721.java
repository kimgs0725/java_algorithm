package algorithm.baekjoon;

import java.io.*;

public class ProblemNo11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String string = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i += 10) {
            if (i + 10 > string.length()) {
                sb.append(string.substring(i));
            } else {
                sb.append(string.substring(i, i + 10)).append('\n');
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
