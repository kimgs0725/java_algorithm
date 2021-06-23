package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class ProblemNo131 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    void dfs(List<List<String>> result, String s, int start, List<String> currentList, boolean[][] dp) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                currentList.add(s.substring(start, end + 1));
                dfs(result, s, end + 1, currentList, dp);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    //public List<List<String>> partition(String s) {
    //    List<List<String>> ans = new ArrayList<>();
    //    dfs(0, ans, new ArrayList<String>(), s);
    //    return ans;
    //}

    //private void dfs(int start, List<List<String>> ans, List<String> currentList, String s) {
    //    if (start >= s.length()) {
    //        ans.add(new ArrayList<>(currentList));
    //    }
    //    for (int end = start; end < s.length(); end++) {
    //        if (isPalindrome(s, start, end)) {
    //            currentList.add(s.substring(start, end + 1));
    //            dfs(end + 1, ans, currentList, s);
    //            currentList.remove(currentList.size() - 1);
    //        }
    //    }
    //}

    //private boolean isPalindrome(String s, int low, int high) {
    //    while (low < high) {
    //        if (s.charAt(low++) != s.charAt(high--)) {
    //            return false;
    //        }
    //    }
    //    return true;
    //}
}
