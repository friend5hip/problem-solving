import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] classes = new int[n];
        for (int i = 0; i < n; i++) {
            classes[i] = sc.nextInt();
        }

        int class1 = sc.nextInt();
        int class2 = sc.nextInt();
        double avg = ((double)(classes[class1-1]) + (double)(classes[class2-1])) / 2;
        System.out.printf("%.1f", avg);
    }
}