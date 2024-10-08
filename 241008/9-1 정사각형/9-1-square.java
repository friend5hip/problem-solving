import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 9;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num == 10) {
                    num -= 1;
                } else if (num == 0) {
                    num += 9;
                }
                System.out.print(num);
                num--;
            }
            System.out.println();
        }
    }
}