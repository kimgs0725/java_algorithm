package algorithm.baekjoon;

import java.io.*;

public class ProblemNo1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String num = br.readLine();
            if (num.equals("0")) {
                break;
            }
            if (num.charAt(0) == '0') {
                for (int i = 0; i < num.length(); i++) {
                    if (num.charAt(i) != '0') {
                        num = num.substring(i);
                        break;
                    }
                }
            }
            sb.append(isPalindrome(num) ? "yes\n" : "no\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static boolean isPalindrome(String str) {
        if (str.length() == 1) {
            return true;
        }

        int s = 0, e = str.length() - 1;
        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) {
                return false;
            }
        }
        return true;
    }
}
