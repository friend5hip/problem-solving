import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[10][10];

        for (int i = 0; i < n; i++) {
            int num = i + 1;
            for (int j = 0; j < n; j++) {
                map[i][j] = num + j * n;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}