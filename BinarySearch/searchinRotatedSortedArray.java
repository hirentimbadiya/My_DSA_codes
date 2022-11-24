public class searchinRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int x = search(nums, target);
        System.out.println(x);
    }

    static int search(int[] arr, int target) {
        int pivot = pivot(arr);
        int start = 0;
        int end = arr.length - 1;
        if (pivot == -1) {
            return BinarySearch(arr, target, start, end);
        }
        if (target == arr[pivot]) {
            return pivot;
        }
        if (target >= arr[start]) {
            return BinarySearch(arr, target, start, pivot - 1);
        } else {
            return BinarySearch(arr, target, pivot + 1, end);
        }
    }

    static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int BinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
