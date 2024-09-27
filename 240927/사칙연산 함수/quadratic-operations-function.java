import java.util.Scanner;

public class Main {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int sub(int a, int b) {
        return a - b;
    }
    public static int div(int a, int b) {
        return a / b;
    }
    public static int mul(int a, int b) {
        return a * b;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String op = sc.next();
        int b = sc.nextInt();
        boolean bool = false;

        switch (op) {
            case "+":
                System.out.println(a + " + " + b + " = " + add(a, b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + sub(a, b));
                break;
            case "/":
                System.out.println(a + " / " + b + " = " + div(a, b));
                break;
            case "*":
                System.out.println(a + " * " + b + " = " + mul(a, b));
                break;
            default:
                System.out.println("False");
                break;
        }
    }
}