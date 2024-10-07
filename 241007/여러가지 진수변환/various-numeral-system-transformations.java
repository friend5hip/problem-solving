import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int b = sc.nextInt();
        int digit = 1;
        int decimal = 0;
        while (num >= 1) {
            int tmp = num % b;
            decimal += tmp * digit;
            digit *= 10;
            num /= b;
        }
        System.out.print(decimal);
    }
}