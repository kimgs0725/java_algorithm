package algorithm.baekjoon;

import java.io.*;

public class ProblemNo10798 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = new String[5];
        int maxLength = -1;
        for (int i = 0; i < line.length; i++) {
            line[i] = br.readLine();
            maxLength = Math.max(maxLength, line[i].length());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < line.length; j++) {
                if (i >= line[j].length()) {
                    continue;
                }
                sb.append(line[j].charAt(i));
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
