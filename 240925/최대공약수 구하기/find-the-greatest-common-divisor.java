import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        while (m != 0) {
           int r = m;
           m = n % m;
           n = r;
        }
        System.out.println(n);
    }
}