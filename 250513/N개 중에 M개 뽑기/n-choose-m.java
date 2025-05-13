import java.util.*;

public class Main {
    static ArrayList<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        getPermutation(0, 1);

        System.out.println(sb);
    }

    static void getPermutation(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(i);
                getPermutation(depth + 1, i);
                answer.remove(answer.size() - 1);
                visited[i] = false;
            }
        }
    }
}