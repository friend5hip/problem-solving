import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int f, s, g, u, d;
    static boolean[] visited;
    static int[] count;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 총 F층 건물, 현재 위치 S층, 목표 위치 G층, U만큼 위로, D만큼 아래로 이동 가능
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        visited = new boolean[f+1];
        count = new int[f+1];

        bfs(s, g);
        System.out.println(flag? count[g] : "use the stairs");
    }

    public static void bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.add(start);
        count[start] = 0;
        while (!q.isEmpty()) {
            int currentFloor = q.poll();

            if (currentFloor == target) {
                flag = true;
                return;
            }

            int[] nextFloors = {currentFloor + u, currentFloor - d};
            for (int nextFloor : nextFloors) {
                if (nextFloor < 1 || nextFloor > f) continue;

                if (!visited[nextFloor]) {
                    visited[nextFloor] = true;
                    q.add(nextFloor);
                    count[nextFloor] = count[currentFloor] + 1;
                }
            }
        }
    }
}
