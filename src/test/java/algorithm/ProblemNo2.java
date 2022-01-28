package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemNo2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] alphabetFreq = new int[26];
        List<Character> alphabetList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i++);
            int num = 0;
            while (i < input.length() && ('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
                num *= 10;
                num += Integer.parseInt(String.valueOf(input.charAt(i++)));
            }
            i--;
            if (!alphabetList.contains(c)) {
                alphabetList.add(c);
            }
            alphabetFreq[c - 'a'] += num;
        }
        for (Character c : alphabetList) {
            System.out.print(c);
            System.out.print(alphabetFreq[c - 'a']);
        }
        System.out.println();
    }
}
