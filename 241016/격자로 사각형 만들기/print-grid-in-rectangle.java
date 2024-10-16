import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], 1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    arr[i][j] = arr[i][j-1] + arr[i-1][j-1] + arr[i-1][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}