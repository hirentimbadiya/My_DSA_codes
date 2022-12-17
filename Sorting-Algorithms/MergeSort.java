import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 67, 8, 0, 9, 6 };
        int[] res = mergesort(arr);
        System.out.println(Arrays.toString(res));
    }

    static int[] mergesort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int[] first, int[] second) {
        int[] ans = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                ans[k++] = first[i++];
            } else {
                ans[k++] = second[j++];
            }
        }

        while (i < first.length) {
            ans[k++] = first[i++];
        }
        while (j < second.length) {
            ans[k++] = second[j++];
        }
        return ans;
    }
}
