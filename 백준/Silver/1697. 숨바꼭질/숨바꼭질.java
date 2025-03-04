import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static int[] elapsedTime;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        elapsedTime = new int[100001];

        bfs(n, k);

        System.out.println(elapsedTime[k]);
    }

    public static void bfs(int startPosition, int targetPosition) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startPosition] = true;
        queue.add(startPosition);
        elapsedTime[startPosition] = 0;
        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();
            if (currentPosition == targetPosition) return;
            // 현재 지점에서 갈 수 있는 모든 점
            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};
            // 갈 수 있는 점을 모두 방문
            for (int nextPosition : nextPositions) {
                if (nextPosition < 0 || nextPosition > 100000) continue;
                if (!visited[nextPosition]) {
                    visited[nextPosition] = true;
                    queue.add(nextPosition);
                    elapsedTime[nextPosition] = elapsedTime[currentPosition] + 1; // 점을 하나 방문할 때마다 현재 점을 방문하는 데 걸린 시간의 1초씩 증가
                }
            }
        }
    }
}
