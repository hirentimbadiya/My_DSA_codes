public class MountainArrayHard {
  public static void main(String[] args) {
    int[] A = { 1, 2, 3, 4, 2, 3, 1 };
    int target = 2;
    int ans = findInMountainArray(target, A);
    System.out.println(ans);
  }

  static int findInMountainArray(int target, int[] arr) {
    int p = peak(arr);
    int x = OrderAgnosticBinarySearch(arr, target, 0, p);
    if (x == -1) {
      x = OrderAgnosticBinarySearch(arr, target, p + 1, arr.length - 1);
    }
    return x;
  }

  static int peak(int[] arr) {
    int start = 0;
    int end = arr.length - 1;
    while (start != end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] < arr[mid + 1]) {
        start = mid + 1;
      } else if (arr[mid] > arr[mid + 1]) {
        end = mid;
      }
    }
    return start;
  }

  static int OrderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target > arr[mid]) {
        start = mid + 1;
      } else if (target < arr[mid]) {
        end = end - 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
