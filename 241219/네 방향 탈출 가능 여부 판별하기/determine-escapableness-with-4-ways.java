import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<List<Edge>> graph;
    static int[] dist;

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n * m; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value == 1) {
                    int current = i * m + j;
                    if (j < m - 1) graph.get(current).add(new Edge(current + 1, 0));
                    if (i < n - 1) graph.get(current).add(new Edge(current + m, 0));
                    if (j > 0) graph.get(current).add(new Edge(current - 1, 1));
                    if (i > 0) graph.get(current).add(new Edge(current - m, 1));
                }
            }
        }

        System.out.println(bfs01(0, n * m - 1) ? 1 : 0);
    }

    static boolean bfs01(int start, int end) {
        dist = new int[n * m];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(start);

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();
            if (current == end) return true;

            for (Edge edge : graph.get(current)) {
                int next = edge.to;
                int newDist = dist[current] + edge.weight;
                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    if (edge.weight == 0) {
                        deque.offerFirst(next);
                    } else {
                        deque.offerLast(next);
                    }
                }
            }
        }
        return false;
    }
}
