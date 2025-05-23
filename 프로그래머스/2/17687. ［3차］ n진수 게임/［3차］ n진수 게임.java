import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        // 2~16진법으로 0부터 나열한다.
        // t개의 숫자를 미리 구한다.
        // m명의 인원이 게임을 한다.
        // p번째 인원이 말해야 할 숫자를 구한다.
        
        // n진법을 나열하려면 n을 넘어가면 자릿수를 늘려 진행한다. (이진법은 0, 1, 10, 11, ...)
        // 만약 100번째에 1000개를 미리 구하려면, 100 * 1000의 숫자를 미리 구해 놓는다. 
        StringBuilder sb = new StringBuilder();
        int num = 0;
        // t * m 자리까지 미리 구해 놓는다. 
        while (sb.length() <= t * m) {
            sb.append(decimalToBaseN(num, n));
            num++;
        }
        
        String calculatedNumber = sb.toString();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            answer.append(calculatedNumber.charAt((p - 1) + i * m)); // p - 1부터 0, m, 2m, ...을 더한다.
        }
        
        return answer.toString();
    }
    
    public static String decimalToBaseN(int decimal, int n) {
        if (decimal == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % n;
            char digit = (char) (remainder < 10 ? remainder + '0' : 'A' + (remainder - 10));
            sb.insert(0, digit);
            decimal /= n;
        }
        
        return sb.toString();
    }
}