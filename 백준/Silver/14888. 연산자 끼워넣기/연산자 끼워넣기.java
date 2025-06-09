import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] numbers;
    static List<Character> operatorList = new ArrayList<>();
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

        // 연산자 개수 입력
        st = new StringTokenizer(br.readLine());
        int[] counts = new int[4]; // + - * /
        for (int i = 0; i < 4; i++) {
            counts[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 리스트 구성
        for (int i = 0; i < counts[0]; i++) operatorList.add('+');
        for (int i = 0; i < counts[1]; i++) operatorList.add('-');
        for (int i = 0; i < counts[2]; i++) operatorList.add('*');
        for (int i = 0; i < counts[3]; i++) operatorList.add('/');

        visited = new boolean[operatorList.size()];
        backtrack(new ArrayList<>());

        System.out.println(max);
        System.out.println(min);
    }

    static void backtrack(List<Character> selected) {
        if (selected.size() == n - 1) {
            int result = calculate(selected);
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }

        // 모든 연산자를 시도해 식을 만든다.
        for (int i = 0; i < operatorList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(operatorList.get(i));
                backtrack(selected);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 완성된 식을 계산한다.
    static int calculate(List<Character> ops) {
        int result = numbers[0];
        for (int i = 0; i < ops.size(); i++) {
            char op = ops.get(i);
            int next = numbers[i + 1];
            switch (op) {
                case '+': result += next; break;
                case '-': result -= next; break;
                case '*': result *= next; break;
                case '/':
                    if (result < 0) {
                        result = -(-result / next);
                    } else {
                        result /= next;
                    }
                    break;
            }
        }
        return result;
    }
}
