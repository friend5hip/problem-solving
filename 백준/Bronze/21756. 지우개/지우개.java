import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        while (list.size() != 1) {
            // 배열에 저장
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            // 홀수 인덱스를 제외하고 다시 리스트에 저장
            list.clear();
            for (int i = 1; i < arr.length; i += 2) {
                list.add(arr[i]);
            }
        }

        System.out.println(list.get(0));
    }
}
