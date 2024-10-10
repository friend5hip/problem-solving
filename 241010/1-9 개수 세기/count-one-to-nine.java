import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 카운트할 배열
        int[] arr = new int[n];
        // 카운트를 저장할 배열
        int[] cnt = new int[10];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            cnt[arr[i]]++;
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println(cnt[i]);
        }
    }
}