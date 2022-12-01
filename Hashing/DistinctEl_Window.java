import java.util.HashMap;

public class DistinctEl_Window {
    static void countDistinct(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");
        for (int i = k; i < arr.length; i++) {
            // delete the element if freq = 1 else decrease the freq by 1
            if (map.get(arr[i - k]) == 1) {
                map.remove(arr[i - k]);
            } else {
                map.put(arr[i - k], map.get(arr[i - k]) - 1);
            }
            // put the new element which is now part of the window.
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            System.out.print(map.size() + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 1, 3, 1, 1, 3 };
        int k = 4;
        countDistinct(arr, k);
    }
}
