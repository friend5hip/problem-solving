import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        boolean[] cols = new boolean[n]; // 열의 퀸 유무
        boolean[] diag1 = new boolean[2 * n - 1]; // 왼쪽 아래 대각선 퀸 유무
        boolean[] diag2 = new boolean[2 * n - 1]; // 오른쪽 아래 대각선 퀸 유무

        System.out.println(dfs(0, cols, diag1, diag2));
    }

    public static int dfs(int row, boolean[] cols, boolean[] diag1 , boolean[] diag2) {
        // 모든 행을 배치한 경우 경우의 수 증가
        if (row == n) {
            return 1;
        }

        int count = 0;
        // 현재 행의 모든 열을 순회하며 경우의 수 탐색
        for (int col = 0; col < n; col++) {
            // 같은 열, 왼쪽 대각선 아래, 오른쪽 대각선 아래 퀸이 없으면 탐색 가능
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + n - 1]) {
                cols[col] = diag1[row + col] = diag2[row - col + n - 1] = true;
                count += dfs(row + 1, cols, diag1, diag2); // 경우의 수 증가
                cols[col] = diag1[row + col] = diag2[row - col + n - 1] = false; // 백트래킹
            }
        }

        return count;
    }
}