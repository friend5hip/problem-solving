import java.util.Scanner;

public class Main {
    public static boolean isMulOf3(int n) {
        if (n % 3 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isThatNum(int n) {
        if (isMulOf3(n)) {
            return true;
        }
        while (n > 0) {
            if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (isThatNum(i) == true) cnt++;
        }
        System.out.print(cnt);
    }
}