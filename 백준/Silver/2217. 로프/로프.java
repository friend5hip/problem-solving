import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }

        // 들 수 있는 최대 중량은 가장 약한 로프를 기준으로 제한된다. -> 로프 하중을 기준으로 오름차순 정렬
        Arrays.sort(ropes);

        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int currentWeight = ropes[i] * (n - i);
            maxWeight = Math.max(maxWeight, currentWeight);
        }

        System.out.println(maxWeight);
    }

}
