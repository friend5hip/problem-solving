import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }

        int under = INT_MAX;
        int over = INT_MAX;
        int minVal = 0;
        int maxVal = 0;
        for (int i = 0; i < arr.length; i++) {
            // 500 미만 수 중 500에서 뺀 값이 제일 작은 값을 찾는다.
            if (arr[i] < 500 && (500 - arr[i]) < under && under > 0) {
                under = 500 - arr[i];
                minVal = arr[i];
            }
            // 500 초과 수 중 값에서 500을 뺀 값이 제일 작은 값을 찾는다.
            else if (arr[i] > 500 && (arr[i] - 500) < over && over > 0) {
                over = arr[i] - 500;
                maxVal = arr[i];
            }
        }

        System.out.print(minVal + " " + maxVal);
    }
}