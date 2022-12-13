import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        int size = 50000;
        int[] A = generateArray(size);
        long start = System.currentTimeMillis();
        Sort(A);
        long end = System.currentTimeMillis();
        long time = (end - start);
        System.out.println("time : " + time);
    }

    static void Sort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
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

    static int[] generateArray(int size) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }
}
