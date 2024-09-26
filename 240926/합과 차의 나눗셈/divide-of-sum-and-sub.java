import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double add = a + b;
        double sub = a - b;
        double answer = add / sub;
        System.out.printf("%.2f", answer);
    }
}