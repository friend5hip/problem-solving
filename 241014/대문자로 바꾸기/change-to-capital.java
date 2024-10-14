import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String row = "";
        for (int i = 0; i < 5; i++) {
            row = sc.nextLine();
            System.out.println(row.toUpperCase());
        }
    }
}