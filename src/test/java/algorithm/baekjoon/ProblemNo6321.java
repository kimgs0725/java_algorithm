package algorithm.baekjoon;

import java.io.*;

public class ProblemNo6321 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String computerName = br.readLine();
            sb.append("String #").append(i).append("\n").append(shiftChar(computerName)).append("\n\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static String shiftChar(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'Z') {
                c = 'A' - 1;
            }
            sb.append((char)(c + 1));
        }
        return sb.toString();
    }
}
