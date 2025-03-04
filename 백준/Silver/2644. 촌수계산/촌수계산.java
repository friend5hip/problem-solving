import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, count;
    static int[] visited;
    static List<Integer>[] graph;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstPerson = Integer.parseInt(st.nextToken());
        int secondPerson = Integer.parseInt(st.nextToken());
        int relations = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < relations; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        visited = new int[n+1];
        queue = new LinkedList<>();
        visited[firstPerson] = 1;
        queue.add(firstPerson);
        System.out.println(bfs(secondPerson));
    }

    public static int bfs(int targetPerson) {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨의 모든 노드 수
            for (int i = 0; i < size; i++) {
                int currentPerson = queue.poll();
                // 대상 인물을 찾은 경우 촌수를 반환
                if (currentPerson == targetPerson) {
                    return count;
                }

                for (int person : graph[currentPerson]) {
                    if (visited[person] == 0) {
                        visited[person] = 1;
                        queue.add(person);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
