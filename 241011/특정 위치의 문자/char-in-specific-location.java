import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = "LEBROS";
        char[] charArr = str.toCharArray();

        Scanner sc = new Scanner(System.in);
        char c = sc.next().charAt(0);

        for (int i = 0; i < charArr.length; i++) {
            if (c == charArr[i]) {
                System.out.println(i);
                return;
            }
        }
        System.out.print("None");
    }
}