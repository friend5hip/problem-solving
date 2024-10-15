import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 변수 선언
        int[][] map1 = new int[3][3];
        int[][] map2 = new int[3][3];

        // 입력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map1[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map2[i][j] = sc.nextInt();
            }
        }

        // 출력
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map1[i][j] * map2[i][j] + " ");
            }
            System.out.println();
        }
    }
}