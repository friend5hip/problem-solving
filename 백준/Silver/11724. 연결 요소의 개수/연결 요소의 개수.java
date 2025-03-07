import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int n, m;
    static List<Integer>[] adjacencyList;
    static int[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

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

        queue = new ArrayDeque<>();
        visited = new int[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                visited[i] = 1;
                bfs();
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            for (int nextNode : adjacencyList[currNode]) {
                if (visited[nextNode] == 0) {
                    visited[nextNode] = 1;
                    queue.add(nextNode);
                }
            }
        }
    }
}