import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        visited = new boolean[n + 1];
        backtracking(0, numbers[0], numbers);

        System.out.println(sb);
    }

    static void backtracking(int depth, int start, int[] numbers) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer.get(i) + " ");
            }
            sb.append("\n");
            return;
        }

        for (int num : numbers) {
            answer.add(num);
            backtracking(depth + 1, start, numbers);
            answer.remove(answer.size() - 1);
        }
    }
}