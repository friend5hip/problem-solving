import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(j + (i * m) + " ");
            }
            System.out.println();
        }
    }
}