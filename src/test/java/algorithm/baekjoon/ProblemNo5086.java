package algorithm.baekjoon;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ProblemNo5086 {

    @Test
    public void test1() {
        assertEquals(divisorMultiple(8, 16), "factor");
        assertEquals(divisorMultiple(32, 4), "multiple");
        assertEquals(divisorMultiple(17, 5), "neither");
        assertEquals(divisorMultiple(8, 8), "factor");
    }

    private static String divisorMultiple(int a, int b) {
        if (a <= b && b % a == 0) {
            return "factor";
        } else if (a % b == 0){
            return "multiple";
        }
        return "neither";
    }
}
