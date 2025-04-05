import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        getPermutation(0);
    }

    static void getPermutation(int currNum) {
        if (currNum == m) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(i);
                getPermutation(currNum + 1);
                answer.remove(answer.size() - 1);
                visited[i] = false;
            }
        }
    }

    static void printAnswer() {
        for (int num : answer) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}