import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        // 2~16진법으로 0부터 나열한다.
        // t개의 숫자를 미리 구한다.
        // m명의 인원이 게임을 한다.
        // p번째 인원의 케이스를 구한다.
        
        // n진법을 나열하려면 n을 넘어가면 자릿수를 늘려 진행한다. (이진법은 0, 1, 10, 11, ...)
        // 만약 100번째에 1000개를 미리 구하려면, 100 * 1000의 숫자를 미리 구해놓아야 한다.
        StringBuilder sb = new StringBuilder("0");
        int num = 1;
        // t * m 자리까지 미리 구해놓는다. 
        while (sb.length() <= t * m) {
            sb.append(decimalToBaseN(num, n));
            num++;
        }
        
        String calculatedNumber = sb.toString();
        
        sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(calculatedNumber.charAt((p - 1) + i * m));
        }
        
        return sb.toString();
    }
    
    public static String decimalToBaseN(int num, int n) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        while (num > 0) {
            int temp = num % n;
            String tempToString = String.valueOf(temp); 
            if (temp >= 10) {
                switch (temp) {
                    case 10: tempToString = "A"; break;
                    case 11: tempToString = "B"; break;
                    case 12: tempToString = "C"; break;
                    case 13: tempToString = "D"; break;
                    case 14: tempToString = "E"; break;
                    case 15: tempToString = "F"; break;
                }
            }
            stack.push(tempToString);
            num /= n;
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
}