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

    static void dfs(int digits) {
        if (digits == n) {
            count++;
            return;
        }
        if (digits > n) return;

        for (int i = 1; i <= 4; i++) {
            if (digits + i > n) continue; // 현재 숫자를 붙였을 때, 아름다운 수가 될 가능성이 없으면 continue
            for (int j = 0; j < i; j++) seq.add(i); // 현재 숫자를 현재 숫자만큼 붙임
            dfs(digits + i);
            for (int j = 0; j < i; j++) {
                seq.remove(seq.size() - 1); // 되돌리기
            }
        }
    }
}