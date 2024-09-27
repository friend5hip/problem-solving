import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int minVal = INT_MAX;
        for (int i = 0; i < n; i++) {
            int sumDistance = 0;
            for (int j = 0; j < n; j++) {
                sumDistance += Math.abs(arr[j] * (j - i));
            }
            minVal = Math.min(minVal, sumDistance);
        }
        System.out.print(minVal);
    }
}