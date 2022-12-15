import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = { 1, 2, 5, 67, 8, 0, 9, 6 };
        Sort(A);
        System.out.println(Arrays.toString(A));
    }

    static void Sort(int[] arr) {
        boolean swapped;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
    }
}
