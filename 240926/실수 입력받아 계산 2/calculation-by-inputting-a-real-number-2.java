import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double newA = a + 1.5;
        System.out.print(Math.round(newA*100)/100.0);
    }
}