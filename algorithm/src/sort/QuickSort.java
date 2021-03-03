package sort;

import java.util.Stack;

public class QuickSort {
    public void qSort(int[] a, int l, int r) {
        if (l < r) {
            int pos = partition(a, l, r);
            qSort(a, l, pos - 1);
            qSort(a, pos + 1, r);
        }
    }

    public void qSort2(int[] a, int l, int h) {
        Stack<Integer> stack = new Stack<>();
        if (l < h) {
            stack.push(l);
            stack.push(h);
            while (!stack.empty()) {
                int high = stack.pop();
                int low = stack.pop();
                int pivot = partition(a, low, high);

                if (low < pivot - 1) {
                    stack.push(low);
                    stack.push(pivot - 1);
                }
                if (pivot + 1 < high) {
                    stack.push(pivot + 1);
                    stack.push(high);
                }
            }
        }
    }

    private int partition(int[] a, int l, int h) {
        int pivot = a[l];
        int i, j;
        while (l < h) {
            while (l < h && a[h] >= pivot) {
                h--;
            }
            if (l < h) {
                a[l++] = a[h];
            }

            while (l < h && a[l] <= pivot) {
                l++;
            }
            if (l < h) {
                a[h--] = a[l];
            }
        }
        a[l] = pivot;
        return l;
    }

    public static void main(String[] args) {
        int[] a = new int[]{32, 12, 7, 78, 23, 45};
        QuickSort quickSort = new QuickSort();
        quickSort.qSort2(a, 0, 5);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
