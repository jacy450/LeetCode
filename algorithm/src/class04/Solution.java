package class04;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int len = n + m;

        if(len % 2 == 1) {
            int k = len / 2;
            double median = getKthElement(nums1, nums2, k + 1);
            return median;
        } else {
            int k1 = len / 2 - 1;
            int k2 = len / 2;

            double median = (getKthElement(nums1, nums2, k1 + 1) + getKthElement(nums1, nums2, k2 + 1)) / 2.0;
            return median;
        }
    }

    private double getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */
        int n = nums1.length;
        int m = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            //边界
            if(index1 == n) {
                return nums2[index2 + k - 1];
            }
            if(index2 == m) {
                return nums1[index1 + k - 1];
            }
            if(k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }
            // 正常情况
            int mid = k / 2;
            int newIndex1 = Math.min(index1 + mid, n) - 1;
            int newIndex2 = Math.min(index2 + mid, m) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if(pivot1 < pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
