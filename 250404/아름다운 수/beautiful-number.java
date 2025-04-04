import java.util.*;

public class Main {
    static int n, count;
    static List<Integer> seq = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dfs(0);
        System.out.println(count);
    }

    static void dfs(int length) {
        if (length == n) {
            count++;
            return;
        }
        if (length > n) return;

        for (int i = 1; i <= 4; i++) {
            if (length + i > n) continue;
            for (int j = 0; j < i; j++) seq.add(i); // i를 i번 추가
            dfs(length + i);
            for (int j = 0; j < i; j++) seq.remove(seq.size() - 1); // 되돌리기
        }
    }
}