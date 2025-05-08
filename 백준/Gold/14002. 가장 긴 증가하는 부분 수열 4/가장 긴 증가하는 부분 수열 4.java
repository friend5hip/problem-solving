import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> dp = new ArrayList<>(); // LIS의 후보값을 저장
        int[] lisEndAt = new int[n];
        int[] parent = new int[n];
        int length = 0;
        int lastIdx = -1;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int idx = findLowerBound(dp, num);
            // 찾은 위치가 후보값 중 가장 큰 경우, 가장 오른쪽에 후보 추가
            // 그렇지 않은 경우 해당 위치의 후보를 새로운 후보로 대체
            if (idx == dp.size()) {
                dp.add(num);
            } else {
                dp.set(idx, num);
            }

            lisEndAt[idx] = i;
            parent[i] = (idx == 0) ? -1 : lisEndAt[idx - 1];

            if (idx + 1 > length) {
                length++;
                lastIdx = i;
            }
        }

        System.out.println(length);
        LinkedList<Integer> lis = new LinkedList<>();
        while (lastIdx != -1) {
            lis.addFirst(arr[lastIdx]);
            lastIdx = parent[lastIdx];
        }
        for (int num : lis) {
            System.out.print(num + " ");
        }
    }

    // 오름차순 정렬된 배열에서 target보다 큰 값이 처음 나오는 위치를 반환
    static int findLowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
