import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int f, s, g, u, d;
    static int[] visited;
    static boolean flag;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 총 F층 건물, 현재 위치 S층, 목표 위치 G층, U만큼 위로, D만큼 아래로 이동 가능
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f+1];
        dy = new int[]{u, -d};
        Arrays.fill(visited, -1);
        bfs(s, g);
        System.out.println(flag? visited[g] : "use the stairs");
    }

    public static void bfs(int start, int target) {
        Deque<Integer> q = new ArrayDeque<>();
        visited[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int currentFloor = q.poll();

            if (currentFloor == target) {
                flag = true;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nextFloor = currentFloor + dy[i];
                if (nextFloor < 1 || nextFloor > f) continue;
                if (visited[nextFloor] == -1) {
                    q.add(nextFloor);
                    visited[nextFloor] = visited[currentFloor] + 1;
                }
            }
        }
    }
}
