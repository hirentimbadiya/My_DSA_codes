import java.util.Arrays;

class HeapifyFunction {
    public static void main(String[] args) {
        int[] arr = { 10, 30, 50, 20, 35, 15, 69, 24 };
        buildHeap(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void buildHeap(int[] arr, int n) {
        // running from first non leaf node.
        for (int i = n / 2 - 1; i >= 0; i--) {
            // passing the index of non leaf node
            heapify(arr, n, i);
            // this function makes balances the heap.
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = left + 1; // right = 2*i + 2

        // if left > parent || right > parent whoever is greater than parent make it
        // largest
        // take care of index out of bounds exception
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // if largest is not our current node then we need to swap
        if (largest != i) {
            swap(arr, largest, i);
            // now again check for our new largest wheather bottom tree is heap or not
            heapify(arr, n, largest);
        }
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
