import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // a가 1 이하가 될 때까지
        int[] cnt = new int[10];
        while (a > 1) {
            int tmp = a % b;
            cnt[tmp]++;
            a = a / b;
        }
        
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Math.pow(cnt[i], 2);
        }

        System.out.print(sum);
    }
}