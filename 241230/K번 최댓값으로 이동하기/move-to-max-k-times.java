import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int k;
    static int[][] grid;
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        // 격자 크기 n과 반복 횟수 k 입력
        n = Integer.parseInt(st1.nextToken());
        k = Integer.parseInt(st1.nextToken());

        // 격자 초기화
        grid = new int[n][n];
        visited = new boolean[n][n];

        // 격자 데이터 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        // 탐색 시작 위치 입력
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st3.nextToken()) - 1;
        int c = Integer.parseInt(st3.nextToken()) - 1;

        // k번 반복
        for (int l = 0; l < k; l++) {
            int[] next = BFS(r, c);
            
            // 더 이상 이동할 수 없으면 종료
            if (next[0] == -1 && next[1] == -1) break;

            r = next[0];
            c = next[1];
        }

        // 최종 위치 출력
        System.out.println((r + 1) + " " + (c + 1));
    }

    static int[] BFS(int startR, int startC) {
        // 방문 배열 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        // 큐 초기화
        q.clear();

        // 초기값
        int currVal = grid[startR][startC];
        int maxVal = -1;
        int nextR = -1, nextC = -1;

        q.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                // 유효하지 않은 전진이면 continue
                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                // 방문했거나 현재 칸보다 크거나 같은 값이면 continue
                if (visited[nr][nc] || grid[nr][nc] >= currVal) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});

                // 방문할 수 있는 칸 중 제일 크거나
                // 최댓값이 동일한 칸 중 제일 작은 행으로
                // 같은 행일 경우 제일 작은 열의 칸으로 이동
                if (grid[nr][nc] > maxVal ||
                        (grid[nr][nc] == maxVal && nr < nextR) ||
                        (grid[nr][nc] == maxVal && nr == nextR && nc < nextC)) {
                    maxVal = grid[nr][nc];
                    nextR = nr;
                    nextC = nc;
                }
            }
        }

        return new int[]{nextR, nextC};
    }
}