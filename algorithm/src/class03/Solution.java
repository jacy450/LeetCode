package class03;

import java.util.HashMap;

/**
 * 滑动窗口
 * 添加了什么元素就弹出左边元素及其之前的元素
 * a b c a b c b b
 * [a b c] 3
 * a [b c a] 3 添加了a,弹出左边的a
 * b [c a b] 3 添加了b,弹出左边的b
 * c [a b c] 3 添加了c,弹出左边的c
 * a b [c b] 2 添加了b,弹出左边b和b之前所有元素
 * c b [b] 1 添加了b,弹出左边b和b之前所有元素
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + i);
        }
        return max;
    }
}
