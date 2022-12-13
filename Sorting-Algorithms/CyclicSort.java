import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 4, 6, 2, 7, 8, 5, 3, 1 };
        Cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Cyclic(int[] Arr) {
        for (int i = 0; i < Arr.length;) {
            int correct = Arr[i] - 1;
            if (Arr[i] != Arr[correct]) {
                swap(Arr, i, correct);
            } else {
                i++; // here i must be in else condition. its very important.
            }

        }
    }

    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
