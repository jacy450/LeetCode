package class01;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(target - nums[i])) {
                return new int[]{res.get(target - nums[i]), i};
            }
            res.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] res = solution.twoSum(nums, target);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
