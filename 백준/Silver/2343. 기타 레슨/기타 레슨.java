import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]); // 가장 긴 강의의 길이가 최소 크기
            right += arr[i];  // 모든 강의를 하나의 블루레이에 담으면 최대 크기
        }

        int answer = right; // 가능한 최댓값을 초기값으로 설정
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPossible(int maxSum) {
        int sumVal = 0;
        int partitionCnt = 1; // 첫 분할

        for (int i = 0; i < n; i++) {
            // 현재 그룹의 합을 초과하면 새로운 그룹 시작
            if (sumVal + arr[i] > maxSum) {
                partitionCnt++;
                sumVal = arr[i];

                if (partitionCnt > m) {  // 분할 개수가 초과되면 불가능
                    return false;
                }
            } else {
                sumVal += arr[i];
            }
        }

        return true;
    }
}
