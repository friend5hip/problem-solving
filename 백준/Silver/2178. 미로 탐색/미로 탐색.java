import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] grid;
    static int[][] visited;
    static Queue<int[]> queue;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n+1][m+1];
        visited = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Character.getNumericValue(str.charAt(j-1));
            }
        }

        queue = new LinkedList<>();
        visited[1][1] = 1;
        queue.add(new int[]{1, 1});

        System.out.println(bfs());
    }

    static int bfs() {
        int minDistance = 1;
        while (!queue.isEmpty()) {
            int sizeOfQueue = queue.size();
            for (int i = 0; i < sizeOfQueue; i++) {
                int[] currentPosition = queue.poll();
                int x = currentPosition[0];
                int y = currentPosition[1];
                
                if (x == n && y == m) {
                    return minDistance;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx > 0 && ny > 0 && nx <= n && ny <= m
                            && visited[nx][ny] == 0 && grid[nx][ny] == 1) {
                        visited[nx][ny] = 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
            minDistance++;
        }
        return -1;
    }
}
