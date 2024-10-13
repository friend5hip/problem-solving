import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while (n != 999 && n != -999) {
            n = sc.nextInt();
            arr.add(n);
        }

        // 오름차순 정렬
        Collections.sort(arr);

        // 마지막 원소가 -999일 시 리스트 내 최댓값 출력 및 인덱스 1 값 출력
        if (arr.contains(-999)) {
            System.out.print(Collections.max(arr) + " " + arr.get(1));
        // 마지막 원소가 999일 시 배열을 reverse한 후 인덱스 1 값 출력 및 리스트 내 최솟값 출력
        } else if (arr.contains(999)) {
            Collections.reverse(arr);
            System.out.print(arr.get(1) + " " + Collections.min(arr));
        }
    }
}