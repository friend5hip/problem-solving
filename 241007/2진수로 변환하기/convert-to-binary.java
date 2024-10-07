import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> binNum = new ArrayList<>();
        int tmp = 0;
        while (true) {
            if (n < 2) {
                binNum.add(tmp++, n);
                break;
            }
            binNum.add(tmp++, n % 2);
            n /= 2;          
        }

        for (int i = tmp - 1; i >= 0; i--) {
            System.out.print(binNum.get(i));
        }
    }
}