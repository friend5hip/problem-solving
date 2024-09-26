import java.util.Scanner;

public class Main {
    public static boolean isThatNum(int n) {
        int ten = n / 10;
        int one = n % 10;
        int sum = ten + one;
        if (sum % 2 == 0 && sum % 5 == 0) {
            return true;
        } else return false;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isThatNum(n)) {
            System.out.println("Yes");
        } else System.out.println("No");
    }
}