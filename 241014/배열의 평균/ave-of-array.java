import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr2d = new int[2][4];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                arr2d[i][j] = sc.nextInt();
            }
        }

        // 행별 평균 출력
        int totalSum = 0;
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += arr2d[i][j];
                totalSum += arr2d[i][j];
            }
            double avg = sum / 4.0;
            System.out.printf("%.1f", avg);
            System.out.print(" ");
        }
        System.out.println();

        // 열별 평균 출력
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            sum += arr2d[0][i] + arr2d[1][i];
            double avg = sum / 2.0;
            System.out.printf("%.1f", avg);
            System.out.print(" ");
        }
        System.out.println();

        // 총합 평균 출력
        System.out.printf("%.1f", totalSum / 8.0);
    }
}