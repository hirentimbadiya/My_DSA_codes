import java.util.*;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 67, 8, 0, 9, 6 };
        Selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Selection(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int lastIndex = n - i - 1;
            int maxIndex = getmax(arr, 0, lastIndex);
            swap(arr, maxIndex, lastIndex);
        }

    }

    static void swap(int[] A, int maxIndex, int lastIndex) {
        int temp = A[maxIndex];
        A[maxIndex] = A[lastIndex];
        A[lastIndex] = temp;
    }

    static int getmax(int[] A, int start, int last) {
        int maxIndex = start;
        for (int i = start; i <= last; i++) {
            if (A[i] > A[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
