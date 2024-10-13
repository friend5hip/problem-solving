import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        int[] isDup = new int[1001];

        for (int i = 0; i < n; i++) {
            int toBeAdded = sc.nextInt();
            if (arr.contains(toBeAdded)) {
                isDup[toBeAdded]++;
            }
            arr.add(toBeAdded);
        }

        for (int i = 0; i < isDup.length; i++) {
            if (isDup[i] > 0) {
                // 중복된 값 i가 있을 경우, arr에서 모든 i 값을 제거
                while (arr.contains(i)) {
                    arr.remove(Integer.valueOf(i));
                }
            }
        }
        if (arr.isEmpty()) {
            System.out.print(-1);
        } else {
            System.out.print(Collections.max(arr));
        }
    }
}