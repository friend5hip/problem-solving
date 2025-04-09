import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;
            String numToStr = String.valueOf(num);
            char[] charArr = numToStr.toCharArray();
            char[] charArr2 = new char[charArr.length];
            int j = 0;
            for (int i = charArr.length - 1; i >= 0; i--) {
                charArr2[j] = charArr[i];
                j++;
            }
            StringBuilder reversed = new StringBuilder();
            for (char ch : charArr2) {
                reversed.append(ch);
            }
            if (num == Integer.parseInt(reversed.toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }
}