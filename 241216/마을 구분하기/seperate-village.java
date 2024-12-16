import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static List<Integer> sizes = new ArrayList<>();
    static int size;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        // 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    size = 0;
                    dfs(i, j);
                    sizes.add(size);
                }
            }
        }
        
        // 출력
        Collections.sort(sizes);
        System.out.println(sizes.size());
        for (int s : sizes) System.out.println(s);
    }
    
    static void dfs(int x, int y) {
        map[x][y] = 0;  // visited 배열 대신 map 직접 수정
        size++;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}