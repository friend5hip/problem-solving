import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }
        Arrays.sort(arr);
        System.out.println(arr[k-1]);
    }
}