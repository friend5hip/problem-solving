import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int MAX_NUM = 100;
    static int[][] visited = new int[MAX_NUM][MAX_NUM];
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int currentBlockSize;    // 최대 블럭의 크기
    static int blockCount = 0;  // 터지는 블럭의 수

    public static void main(String[] args) throws IOException {
        // n * n 크기의 격자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int maxBlockSize = 0;

        for (int i =0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 인접한 칸의 숫자가 동일한 개수가 4개 이상인 경우, 터짐
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    currentBlockSize = 0;
                    DFS(i, j);
                    if (currentBlockSize >= 4) {
                        blockCount++;
                    }
                    maxBlockSize = Math.max(currentBlockSize, maxBlockSize);
                }
            }
        }

        // 터지게 되는 블럭 수와 최대 블럭 크기를 출력
        System.out.print(blockCount + " " + maxBlockSize);
    }

    static void DFS(int x, int y) {
        visited[x][y] = 1;
        int currentNumber = grid[x][y];
        currentBlockSize++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (possible(nx, ny, currentNumber)) {
                DFS(nx, ny);
            }
        }
    }

    static boolean possible(int x, int y, int currentNumber) {
        return inRange(x, y) && visited[x][y] == 0 && grid[x][y] == currentNumber;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}