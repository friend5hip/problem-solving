import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
        }

        int under = 0;
        int over = 0;
        for (int i = 0; i < arr.length; i++) {
            if (500 - arr[i] < under && under >= 0) {
                under = arr[i];
            }
            if (arr[i] - 500 > over && over >= 0) {
                over = arr[i];
            }
        }

        System.out.print(under + " " + over);
    }
}