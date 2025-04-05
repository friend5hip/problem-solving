import java.util.*;
import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();

        // 숫자를 찾을 때까지 계속 push
        // 숫자를 찾은 경우 pop
        Stack<Integer> stack = new Stack<>();
        int targetIndex = 0;
        int pushNum = 1;
        while (targetIndex < sequence.length) {
            int target = sequence[targetIndex];
            while (true) {
                if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop(); sb.append("-\n");
                    break;
                } else {
                    if (pushNum > n) {
                        System.out.println("NO");
                        return;
                    }
                    stack.push(pushNum); sb.append("+\n");
                    pushNum++;
                }
            }
            targetIndex++;
        }

        System.out.println(sb);
    }
}