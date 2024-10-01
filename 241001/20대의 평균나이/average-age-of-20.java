import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0;
        double cnt = 0;
        while (true) {
            int age = sc.nextInt();
            if (age >= 30 || age < 20)
                break;
            sum += age;
            cnt++;
        }
        double avg = sum / cnt;
        System.out.printf("%.2f", avg);
    }
}