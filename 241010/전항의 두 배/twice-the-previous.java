import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        int second = sc.nextInt();
        int[] seq = new int[10];

        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                seq[i] = first;
            } 
            else if (i == 1) {
                seq[i] = second;
            } 
            else {
                seq[i] = seq[i-1] + 2 * seq[i-2];
            }
            System.out.print(seq[i] + " ");
        }
    }
}