import java.util.*;

public class Main {
    public static int aToDecimal(int num, int a) {
        int digit = 1;
        int decimal = 0;
        while (num > 0) {
            int tmp = num % 10;
            decimal += tmp * digit;
            digit *= a;
            num /= 10;
        }
        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int aToDec = aToDecimal(n, a);
        ArrayList<Integer> result = new ArrayList<>();
        while (aToDec > 0) {
            int tmp = aToDec % b;
            result.add(tmp);
            aToDec /= b;
        }
        Collections.reverse(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
        }
    }
}