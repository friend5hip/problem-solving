import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int onetonine = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(onetonine + " ");
                // 10이 넘어가면 1로 초기화
                if (onetonine < 9) {
                    onetonine += 1;
                } else {
                    onetonine = onetonine % 8;
                }
            }
            System.out.println(" ");
        }
    }
}