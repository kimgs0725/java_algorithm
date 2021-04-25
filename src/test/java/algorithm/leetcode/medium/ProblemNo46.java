package algorithm.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemNo46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        buildPermutations(new Stack<>(),
                new LinkedList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())),
                output);
        return output;
    }

    private void buildPermutations(Stack<Integer> placed, Queue<Integer> unplaced, List<List<Integer>> output) {
        int remaining = unplaced.size();
        if (remaining == 0) {
            output.add(new ArrayList<>(placed));
        } else {
            for (int i = 0; i < remaining; i++) {
                placed.push(unplaced.remove());
                buildPermutations(placed, unplaced, output);
                unplaced.add(placed.pop());
            }
        }
    }

    //private List<List<Integer>> permute(int[] nums) {
    //    List<List<Integer>> output = new ArrayList<>();
    //    Integer[] interim = new Integer[nums.length];
    //    permute(nums, 0, interim, output);
    //    return output;
    //}

    //private void permute(int[] nums, int index, Integer[] interim, List<List<Integer>> output) {
    //    if (index == nums.length) {
    //        output.add(Arrays.asList(interim));
    //        return;
    //    }

    //    for (int i = 0; i < nums.length; i++) {
    //        if (interim[i] == null) {
    //            Integer[] arr = Arrays.copyOf(interim, interim.length);
    //            arr[i] = nums[index];
    //            permute(nums, index + 1, arr, output);
    //        }
    //    }
    //}
}
