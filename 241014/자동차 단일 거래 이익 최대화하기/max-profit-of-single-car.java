import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }

        int currentProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[i] != arr[j]) {
                    if (arr[j] - arr[i] > 0 && arr[j] - arr[i] > currentProfit) {
                        currentProfit = arr[j] - arr[i];
                    }
                }
            }
        }

        System.out.println(currentProfit);
    }
}