package algorithm.baekjoon;

import java.io.*;

public class ProblemNo11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());
        int s = 0;
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            String[] str = br.readLine().split(" ");
            String inst = str[0];
            switch (inst) {
                case "add": {
                    int arg = Integer.parseInt(str[1]);
                    s = s | (1 << (arg - 1));
                    break;
                }
                case "remove": {
                    int arg = Integer.parseInt(str[1]);
                    int mask = ~(1 << (arg - 1));
                    s = s & mask;
                    break;
                }
                case "check": {
                    int arg = Integer.parseInt(str[1]);
                    sb.append(((s & (1 << (arg - 1))) != 0) ? "1\n" : "0\n");
                    break;
                }
                case "toggle": {
                    int arg = Integer.parseInt(str[1]);
                    s ^= (1 << (arg - 1));
                    break;
                }
                case "all": {
                    s |= (~0);
                    break;
                }
                case "empty": {
                    s = 0;
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
