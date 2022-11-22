public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = { -2, 0, 4, 5, 6, 7, 12, 17, 20, 34 };
        int target = 4;
        int res = ans(arr, target);
        System.out.println(res);
    }

    static int ans(int[] arr, int target) {

        // fisrt we will take size 2 box then we will exponentially increase it until we
        // find the box in which out target element lies.
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newS = end + 1;
            // end = previous end + sizeofbox *2;
            end = end + (end - start + 1) * 2; // new end
            start = newS; // new start
        }
        return BinarySearch(arr, target, start, end);
    }

    static int BinarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = end - 1;
            } else if (target > arr[mid]) {
                start = start + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

}
