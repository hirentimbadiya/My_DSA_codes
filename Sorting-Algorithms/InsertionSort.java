import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 67, 8, 0, 9, 6 };
        Insertion(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Insertion(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // or you can go <= arr.length -2 ,too
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void swap(int[] A, int max, int last) {
        int temp = A[max];
        A[max] = A[last];
        A[last] = temp;
    }
}
