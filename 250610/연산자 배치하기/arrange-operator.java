import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static List<Character> ops = new ArrayList<>();
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        ops = new ArrayList<>();
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        for (int i = 0; i < plus; i++) ops.add('+');
        for (int i = 0; i < minus; i++) ops.add('-');
        for (int i = 0; i < mul; i++) ops.add('*');

        visited = new boolean[n - 1];
        dfs(new ArrayList<>());
        System.out.println(min + " " + max);
    }

    // 모든 연산자 순열을 만든다.
    static void dfs(List<Character> selected) {
        // 모든 연산자를 고르면 계산한다.
        if (selected.size() == n - 1) {
            int result = calculate(selected);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(ops.get(i));
                dfs(selected);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 식을 계산한다.
    static int calculate(List<Character> ops) {
        int result = numbers[0];
        for (int i = 0; i < ops.size(); i++) {
            int next = numbers[i + 1];
            switch (ops.get(i)) {
                case '+': result += next; break;
                case '-': result -= next; break;
                case '*': result *= next; break;
            }
        }
        return result;
    }

}
