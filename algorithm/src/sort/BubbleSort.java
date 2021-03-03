package sort;

import java.util.Arrays;

public class BubbleSort {
    public void sort_1(int[] num) {
        int len = num.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int tmp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                }
            }
        }
    }

    public void sort_2(int[] num) {
        int len = num.length;
        for (int i = 0; i < len - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int tmp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                    flag = true;
                }
            }
            if(!flag) {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 1, -7, 4, 9, -6, 8, 10, 4};
        BubbleSort sort = new BubbleSort();
        sort.sort_2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
