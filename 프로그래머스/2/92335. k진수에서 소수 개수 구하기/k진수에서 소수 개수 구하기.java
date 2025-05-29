import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String[] targets = getNBasedNumber(n, k).split("0");
        int count = 0;
        // int start = 0;
        // for (int end = 0; end <= nBasedNum.length(); end++) {
        //     // 구간 끝이거나 0을 만나면 토큰 완성
        //     if (end == nBasedNum.length() || nBasedNum.charAt(end) == '0') {
        //         if (start < end) {
        //             String token = nBasedNum.substring(start, end);
        //             if (!token.contains("0") && isPrime(Long.parseLong(token))) {
        //                 count++;
        //             }
        //         }
        //         start = end + 1; // 다음 구간 시작
        //     }
        // }
        for (String num : targets) {
            if (num.equals("")) continue;
            if (isPrime(Long.parseLong(num))) {
                count++;
            }
        }

        return count;
    }

    public String getNBasedNumber(int num, int base) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % base);
            num /= base;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long num) {
        if (num < 2) return false;
        long sqrt = (long) Math.sqrt(num);
        for (long i = 2; i <= sqrt; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
