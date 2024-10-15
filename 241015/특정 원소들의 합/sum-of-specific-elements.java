import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int[][] arr_2d = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr_2d[i][j] = sc.nextInt();
                if (j <= i) {
                    sum += arr_2d[i][j];
                }
            }
        }
        
        System.out.print(sum);
    }
}