import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int minVal = INT_MAX;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] != arr[j]) {
                    if (Math.abs(arr[i] - arr[j]) < minVal) {
                        minVal = Math.abs(arr[i] - arr[j]);
                    }
                }
            }
        }

        System.out.print(minVal);
    }
}