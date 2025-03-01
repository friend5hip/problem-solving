import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static List<Integer>[] adjacencyList;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        adjacencyList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyList[from].add(to);
            adjacencyList[to].add(from);
        }

        // 작은 노드 먼저 탐색하도록 정렬해준다.
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjacencyList[i]);
        }

        visited = new int[n+1];
        dfs(v);
        System.out.println();

        visited = new int[n+1];
        bfs(v);
    }

    static void dfs(int node) {
        visited[node] = 1;
        System.out.print(node + " ");

        for (int nextNode : adjacencyList[node]) {
            if (visited[nextNode] == 0) {
                dfs(nextNode);
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = 1;
        queue.add(node);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            for (int nextNode : adjacencyList[currentNode]) {
                if (visited[nextNode] == 0) {
                    visited[nextNode] = 1;
                    queue.add(nextNode);
                }
            }
        }
    }
}
