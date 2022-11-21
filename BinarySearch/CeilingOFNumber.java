public class CeilingOFNumber {
    public static void main(String[] args) {
        int[] A = { -18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89 };
        int target = 8;
        int ans = ceiling(A, target);
        System.out.println("Ceiling number : " + ans);
        int count = Floor(A, target);
        System.out.println("Floor number : " + count);
    }

    // returns the smallest element which is grater than or equal to target element.
    static int ceiling(int Arr[], int target) {
        int start = 0;
        int end = Arr.length - 1;

        if (target > Arr[end]) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (Arr[mid] == target) {
                return Arr[mid];
            } else if (Arr[mid] > target) {
                end = mid - 1;
            } else if (Arr[mid] < target) {
                start = mid + 1;
            }
        }
        return Arr[start];
    }

    // returns the greatest element which is smaller than or equal to targetelement.
    static int Floor(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        if (target < A[start]) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return A[mid];
            }
            if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return A[end];
    }
}
