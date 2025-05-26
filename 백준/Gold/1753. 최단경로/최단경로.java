import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static class Node implements Comparable<Node> {
        int to;
        int w;
        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, w));
        }

        dist = new int[v + 1];
        dijkstra(startV);

        for (int i = 1; i <= v; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    private static void dijkstra(int startV) {
        Arrays.fill(dist, INF);
        dist[startV] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startV, 0));

        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            int curr = currNode.to;
            int currDist = currNode.w;

            if (currDist > dist[curr]) continue;

            for (Node neighbor : graph.get(curr)) {
                int next = neighbor.to;
                int nextDist = currDist + neighbor.w;

                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    pq.add(new Node(next, nextDist));
                }
            }
        }
    }

}