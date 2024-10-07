import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int binary = sc.nextInt();
        ArrayList<Integer> binArr = new ArrayList<>();
        while (binary >= 1) {
            int tmp = binary % 10;
            binArr.add(tmp);
            binary /= 10;
        }

        int digit = 1;
        int decimal = 0;
        for (int i = 0; i < binArr.size(); i++) {
            decimal += binArr.get(i) * digit;
            digit *= 2;
        }
        System.out.print(decimal);
    }
}