import java.util.Scanner;

class Fibbonacci {
    static int fibbonacciNo(int num) {
        if (num < 2) {
            return num;
        }
        return fibbonacciNo(num - 1) + fibbonacciNo(num - 2);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the number : ");
        int num = in.nextInt();
        int x = fibbonacciNo(num);
        System.out.println(x);
    }
}
