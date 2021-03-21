package algorithm.baekjoon;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemNo2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    @Test
    void test() {
        assertEquals(2, gcd(4, 6));
        assertEquals(12, lcm(4, 6));
        assertEquals(1, gcd(3, 5));
        assertEquals(15, lcm(3, 5));
        assertEquals(6, gcd(24, 18));
        assertEquals(72, lcm(24, 18));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
