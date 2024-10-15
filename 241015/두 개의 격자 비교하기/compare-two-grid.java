import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map1 = new int[n][m];
        int[][] map2 = new int[n][m]; 
        int[][] result = new int[n][m];

        // 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map2[i][j] = sc.nextInt();
            }
        }

        // 계산 및 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map1[i][j] == map2[i][j]) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = 1;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}