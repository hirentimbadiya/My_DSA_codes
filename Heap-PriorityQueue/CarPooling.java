import java.util.Map;
import java.util.TreeMap;

public class CarPooling {
    static boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i[] : trips) {
            map.put(i[1], map.getOrDefault(i[1], 0) + i[0]);
            map.put(i[2], map.getOrDefault(i[2], 0) - i[0]);
        }
        for (int v : map.values()) {
            capacity = capacity - v;
            if (capacity < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }
}
