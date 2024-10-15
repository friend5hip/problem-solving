import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(arr[i], 1);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i > 0 && j > 0) {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}