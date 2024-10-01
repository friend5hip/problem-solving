import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            a[i] = tmp;
        }
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            b[i] = tmp;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a, b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}