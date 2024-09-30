import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt();
        String sex1 = sc.next();

        int age2 = sc.nextInt();
        String sex2 = sc.next();

        if ((age1 > 19 || age2 > 19) || (sex1 == "M" || sex2 == "M")) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}