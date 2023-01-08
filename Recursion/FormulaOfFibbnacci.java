import java.util.Scanner;

// f(n) = 1/root(5) * ((1 + root(5))/2)^n
public class FormulaOfFibbnacci {
    static int fibboFormula(int n) {
        return (int) (((Math.pow((1 + Math.sqrt(5)) / 2, n)) - (Math.pow((1 - Math.sqrt(5)) / 2, n))) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the number : ");
        int num = in.nextInt();
        int x = fibboFormula(num);
        System.out.println(x);
    }
}
