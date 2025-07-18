import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static class Edge implements Comparable<Edge> {
        int to;
        int w;
        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w, o.w);
        }
    }
    static ArrayList<ArrayList<Edge>> graph;
    static long[] dist;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Edge(to, w));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dist = new long[v + 1];
        dijkstra(from);

        System.out.println(dist[to]);
    }

    private static void dijkstra(int startV) {
        Arrays.fill(dist, INF);
        dist[startV] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(startV, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int currV = curr.to;
            int currDist = curr.w;

            if (currDist > dist[currV]) continue;

            for (Edge neighbor : graph.get(currV)) {
                int next = neighbor.to;
                int nextDist = currDist + neighbor.w;

                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    pq.add(new Edge(next, nextDist));
                }
            }
        }
    }

}