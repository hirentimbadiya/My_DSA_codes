import java.util.Arrays;

import javax.swing.text.TabExpander;

public class Code {
    public static void main(String[] args) {
        int[][] A = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 28, 29, 37, 49 },
                { 33, 34, 38, 50 }
        };

        System.out.println(Arrays.toString(Search(A, 37)));
    }

    static int[] Search(int[][] A, int target) {
        int row = 0;
        int col = A.length - 1;

        while (row < A.length && col >= 0) {
            if (target == A[row][col]) {
                return new int[] { row, col };
            }
            if (target > A[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return new int[] { -1, -1 };
    }
}
