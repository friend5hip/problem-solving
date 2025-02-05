import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 노드 방문 회수
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[] visited = new boolean[N+1];
        int[][] graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // 그래프를 깊이 우선 탐색
        DFS(1, N, graph, visited);

        // 방문할 수 있는 노드를 탐색한 횟수를 출력
        System.out.println(count);
    }

    static void DFS(int vertex, int vertices, int[][] graph, boolean[] visited) {
        visited[vertex] = true;
        for (int currV = 1; currV <= vertices; currV++) {
            if (graph[vertex][currV] == 1 && !visited[currV]) {
                count++;
                visited[currV] = true;
                DFS(currV, vertices, graph, visited);
            }
        }
    }

}