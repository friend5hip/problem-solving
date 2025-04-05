import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        visited = new boolean[n+1];
        getPermutation(0);
    }

    static void getPermutation(int depth) {
        if (depth == n) {
            printAnswer();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer.add(i);
                getPermutation(depth + 1);
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