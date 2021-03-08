package class05;

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        StringBuilder res = new StringBuilder();

        for (int l = 0; l < len; l++) {
            for (int i = 0; i + l < len; i++) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j] && l + 1 > res.length()) {
                    res.setLength(0);
                    res.append(s, i, j + 1);
                }
            }
        }
        return res.toString();
    }

    public String longestPalindrome2(String s) {
        int st = 0, ed = 0;
        int len = s.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int len1 = lengthAroundCenter(s, i, i);
            int len2 = lengthAroundCenter(s, i, i + 1);
            int temp = Math.max(len1, len2);
            if(temp > ed - st) {
                st = i - (temp - 1) / 2;
                ed = i + temp / 2;
            }
        }
        return res.append(s, st, ed + 1).toString();
    }

    private int lengthAroundCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        String s = new String("cbbd");
        Solution solution = new Solution();
        String s1 = solution.longestPalindrome2(s);
        System.out.println(s1);
    }
}
