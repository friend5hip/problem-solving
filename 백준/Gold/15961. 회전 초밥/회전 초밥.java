import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c;
    static int[] dishes = new int[3000001];
    static int[] countingArray = new int[3001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());   // 모든 접시의 수
        d = Integer.parseInt(st.nextToken());   // 모든 초밥의 가짓수
        k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken());   // 쿠폰 번호 c

        for (int i = 1; i <= n; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int uniqueSushi = 0;

        // 초기 윈도우 설정
        for (int i = 1; i <= k; i++) {
            if (countingArray[dishes[i]] == 0) {
                uniqueSushi++;
            }
            countingArray[dishes[i]]++;
        }

        // 초기 윈도우에 쿠폰 초밥이 있으면 가짓수 +1
        int max;
        if (countingArray[c] == 0) {
            max = uniqueSushi + 1;
        } else {
            max = uniqueSushi;
        }

        for (int i = 1; i <= n; i++) {
            // 현재 윈도우의 가장 왼쪽 스시 제거
            countingArray[dishes[i]]--;
            if (countingArray[dishes[i]] == 0) {
                uniqueSushi--;
            }

            // 새로운 접시의 인덱스(n을 초과하면 n을 빼서 순환)
            int newIndex = i + k;
            if (newIndex > n) {
                newIndex -= n;
            }

            // 새 접시 추가 전 해당 초밥이 윈도우에 없으면 가짓수 +1
            if (countingArray[dishes[newIndex]] == 0) {
                uniqueSushi++;
            }
            countingArray[dishes[newIndex]]++;

            // 쿠폰 초밥 처리
            int current = uniqueSushi;
            if (countingArray[c] == 0) {
                current++;
            }

            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
