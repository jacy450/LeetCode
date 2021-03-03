package sort;

public class MergeSort {
    public void mSort(int[] a, int l, int h) {
        if (l < h) {
            int mid = (l + h) >> 1;
            mSort(a, l, mid);
            mSort(a, mid + 1, h);
            merge(a, l, mid, h);
        }
    }

    public void mSort2(int[] a) {
        int len = a.length;
        int step = 1;
        while (step < len) {
            for (int i = 0; i < step; i += 2 * step) {
                int l = i;
                int mid = i + step - 1;

                if (mid > len - 1) {
                    continue;
                }
                int h = i + 2 * step - 1;
                if (h > len) {
                    h = len - 1;
                }
                merge(a, l, mid, h);
            }
            step *= 2;
        }
    }

    public void merge(int[] a, int l, int mid, int h) {
        int i = l, j = mid, n = mid + 1, m = h;
        int[] tmp = new int[h - l + 1];
        int k = 0;
        while (i <= j && n <= m) {
            if (a[i] < a[n]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[n++];
            }
        }

        while (i <= j) tmp[k++] = a[i++];
        while (n <= m) tmp[k++] = a[n++];
        for (int x : tmp) {
            a[l++] = x;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{32, 12, 7, 78, 23, 45};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mSort2(a);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
