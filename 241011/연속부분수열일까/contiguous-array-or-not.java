import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] a = new int[n1];
        for (int i = 0; i < n1; i++) {
            int tmp = sc.nextInt();
            a[i] = tmp;
        }

        int[] b = new int[n2];
        for (int i = 0; i < n2; i++) {
            int tmp = sc.nextInt();
            b[i] = tmp;
        }

        // 정수 배열을 문자열로 변환
        String aToStr = Arrays.toString(a).replaceAll("[^0-9]","");
        String bToStr = Arrays.toString(b).replaceAll("[^0-9]","");

        // string이 substring을 포함하는지 확인
        if (aToStr.contains(bToStr)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}