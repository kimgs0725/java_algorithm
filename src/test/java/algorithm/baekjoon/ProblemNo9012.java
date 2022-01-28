package algorithm.baekjoon;

import java.io.*;
import java.util.Stack;

public class ProblemNo9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String ps = br.readLine();
            boolean valid = true;
            for (int i = 0; i < ps.length(); i++) {
                if (ps.charAt(i) == '(') {
                    stack.push(ps.charAt(i));
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.empty() || !valid) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
            stack.clear();
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
