import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int f, s, g, u, d;
    static int[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 총 F층 건물, 현재 위치 S층, 목표 위치 G층, U만큼 위로, D만큼 아래로 이동 가능
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new int[f+1];
        Arrays.fill(visited, -1);
        bfs(s, g);
        System.out.println(flag? visited[g] : "use the stairs");
    }

    public static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 0;
        q.add(start);
        while (!q.isEmpty()) {
            int currentFloor = q.poll();

            if (currentFloor == target) {
                flag = true;
                return;
            }

            int[] nextFloors = {currentFloor + u, currentFloor - d};
            for (int nextFloor : nextFloors) {
                if (nextFloor < 1 || nextFloor > f) continue;

                if (visited[nextFloor] == -1) {
                    q.add(nextFloor);
                    visited[nextFloor] = visited[currentFloor] + 1;
                }
            }
        }
    }
}
