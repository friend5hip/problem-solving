import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }
        for (int i = 0; i < n; i++) {
            if ((arr[i] % 2 != 0) && (arr[i] % 3 == 0)) {
                System.out.println(arr[i]);
            }
        }
    }
}