import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int binary = sc.nextInt();

        // 십진수 변환
        int digit = 1;
        int binToDec = 0;
        while (binary >= 1) {
            int tmp = binary % 10;
            binToDec += tmp * digit;
            digit *= 2;
            binary /= 10;
        }
        binToDec *= 17;

        // 이진수 변환
        ArrayList<Integer> decToBin = new ArrayList<>();
        while (binToDec >= 1) {
            int tmp = binToDec % 2;
            decToBin.add(tmp);
            binToDec /= 2;
        }

        // 순서 뒤집기
        Collections.reverse(decToBin);
        for (int i = 0; i < decToBin.size(); i++) {
            System.out.print(decToBin.get(i));
        }
    }
}