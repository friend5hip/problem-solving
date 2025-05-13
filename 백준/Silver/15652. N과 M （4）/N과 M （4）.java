import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        backtracking(0, 1);

        System.out.println(sb);
    }

    static void backtracking(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            answer.add(i);
            backtracking(depth + 1, i);
            answer.remove(answer.size() - 1);
        }
    }
}