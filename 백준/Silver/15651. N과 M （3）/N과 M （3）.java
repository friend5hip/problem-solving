import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> answer = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        backtracking(0);

        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer.get(i) + " ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            answer.add(i);
            backtracking(depth + 1);
            answer.remove(answer.size() - 1);
        }
    }
}
