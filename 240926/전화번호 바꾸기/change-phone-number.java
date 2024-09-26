import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.print(a.substring(0, 3) + a.substring(8, a.length()) + a.substring(3, 8));
    }
}