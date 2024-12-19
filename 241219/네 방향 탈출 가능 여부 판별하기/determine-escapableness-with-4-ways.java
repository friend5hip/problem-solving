import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int MAX_NUM = 100;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[][] visited = new int[MAX_NUM][MAX_NUM];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static Queue<Pair> q = new LinkedList<>();
    static boolean canEscape = false;

    public static void main(String[] args) throws IOException {
        // n * m의 격자 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 좌측 상단부터 시작
        push(0, 0);
        // 너비 우선 검색
        BFS();

        System.out.println(canEscape ? 1 : 0);
    }

    static void BFS() {
        // 탐색 가능한 칸이 있을 경우 반복
        while (!q.isEmpty()) {
            // 현재 탐색 위치
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;
            // 우측 하단 도달 시 탈출 처리
            if (x == n-1 && y == m-1) {
                canEscape = true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 격자 범위 안에서 방문한 적이 없고, 격자가 1일 경우 탐색 가능
                if (possible(nx, ny)) {
                    push(nx, ny);
                }
            }
        }
    }

    static void push(int x, int y) {
        visited[x][y] = 1;
        q.add(new Pair(x, y));
    }

    static boolean possible(int x, int y) {
        return inRange(x, y) && visited[x][y] == 0 && grid[x][y] == 1;
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}