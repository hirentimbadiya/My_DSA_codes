import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 0, 5, 7, 9, 2, 4, 1, 8, 3 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] Arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = Arr[mid];
        while (start <= end) {
            while (Arr[start] < pivot) {
                start++;
            }
            while (Arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = Arr[start];
                Arr[start] = Arr[end];
                Arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(Arr, start, high);
        quickSort(Arr, low, end);
    }
}
