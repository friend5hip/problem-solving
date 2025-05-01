import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        // 2차원 dp 배열을 사용해서 첫 번째 문자열, 두 번째 문자열의 모든 선택 경우를 추적
        // 둘 중 어느 한 문자열의 길이가 0인 경우 공통 수열은 존재할 수 없으므로 초기값은 0
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                // 문자가 일치하는 경우, 카운트
                // 문자가 일치하지 않는 경우, 두 선택지 중 더 긴 것을 선택
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[str1.length()][str2.length()]);
    }
}
