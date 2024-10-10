import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int[] dice = new int[10];
        for (int i = 0; i < 10; i++) {
            dice[i] = sc.nextInt();
        }
        
        int[] cnt = new int[7];
        for (int i = 0; i < 10; i++) {
            cnt[dice[i]]++;
        }

        for (int i = 1; i <= 6; i++) {
            System.out.println(i + " - " + cnt[i]);
        }
    }
}