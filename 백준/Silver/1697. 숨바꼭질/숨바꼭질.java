import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] visited, elapsedTime;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        visited = new int[1000001];
        elapsedTime = new int[100001];
        queue = new LinkedList<>();
        visited[n] = 1;
        queue.add(n);
        bfs(n, k);
        System.out.println(elapsedTime[k]);
    }

    public static void bfs(int start, int target) {
        elapsedTime[start] = 0;
        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();

            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};

            for (int nextPosition : nextPositions) {
                if (nextPosition < 0 || nextPosition > 100000) {
                    continue;
                }

                if (visited[nextPosition] == 0) {
                    visited[nextPosition] = 1;
                    queue.add(nextPosition);
                    if (nextPosition == target) {
                        elapsedTime[nextPosition] = elapsedTime[currentPosition] + 1;
                        return;
                    } else {
                        elapsedTime[nextPosition] = elapsedTime[currentPosition] + 1;
                    }
                }
            }
        }
    }
}
