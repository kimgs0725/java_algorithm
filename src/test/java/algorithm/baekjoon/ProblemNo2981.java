package algorithm.baekjoon;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class ProblemNo2981 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nList = new int[n];
        for (int i = 0; i < n; i++) {
            nList[i] = sc.nextInt();
        }
        int[] sameMod = findSameMod(nList);
        for (int i = 0; i < sameMod.length; i++) {
            System.out.print(sameMod[i] + " ");
        }
    }

    @Test
    void test() {
        int[] nList = new int[]{6, 34, 38};
        assertThat(findSameMod(nList)).contains(2, 4);
    }

    private static int[] findSameMod(int[] nList) {
        int[] ret = new int[nList[nList.length-1]];
        int ind = 0;
        int lastNum = nList[nList.length-1];
        for (int i = 2; i < lastNum; i++) {
            int mod = nList[0] % i;
            boolean isSame = true;
            for (int n : nList) {
                if (n % i != mod) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                ret[ind++] = i;
            }
        }
        return ret;
    }
}
