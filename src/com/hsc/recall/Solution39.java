package com.hsc.recall;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        dfs(target, 0, candidates, cur, ans);
        return ans;
    }

    private void dfs(int target, int index, int[] candidates, ArrayList<Integer> cur,
                     List<List<Integer>> ans) {
        if (index == candidates.length) {
            return;
        }

        // 满足条件
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        // 不选当前数
        dfs(target, index + 1, candidates, cur, ans);
        // 选当前数
        if (target - candidates[index] >= 0) {
            cur.add(candidates[index]);
            dfs(target - candidates[index], index, candidates, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
