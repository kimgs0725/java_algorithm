package algorithm.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ProblemNo39 {

    @Test
    void test() {
        printTest(combinationSum(new int[]{2, 3, 6, 7}, 7));
        printTest(combinationSum(new int[]{2, 3, 5}, 8));
        printTest(combinationSum(new int[]{2}, 1));
        printTest(combinationSum(new int[]{1}, 1));
        printTest(combinationSum(new int[]{1}, 2));
    }

    private void printTest(List<List<Integer>> list) {
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + ", ");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        getResult(result, new Stack<Integer>(), candidates, target, 0);
        return result;
    }

    private void getResult(List<List<Integer>> result, Stack<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                //cur.add(candidates[i]);
                cur.push(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i);
                cur.pop();
            }//for
        }//if
        else if(target == 0 ){
            result.add(new ArrayList<Integer>(cur));
        }//else if
    }
}
