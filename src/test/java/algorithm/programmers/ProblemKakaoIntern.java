package algorithm.programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

public class ProblemKakaoIntern {

    @Test
    void test() {
        assertThat(solution(new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        }, new int[]{1,5,3,5,1,2,1,4})).isEqualTo(4);
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int line = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[j][line] != 0) {
                    int doll = board[j][line];
                    board[j][line] = 0;
                    if (stack.empty() || stack.peek() != doll) {
                        stack.push(doll);
                    } else {
                        stack.pop();
                        answer+=2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
