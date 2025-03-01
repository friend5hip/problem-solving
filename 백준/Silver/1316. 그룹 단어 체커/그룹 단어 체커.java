import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < n; i++) {
            String targetString = br.readLine();
            boolean[] countingArray = new boolean[256];

            boolean isGroupWord = true;
            for (int j = 0; j < targetString.length(); j++) {
                char currentChar = targetString.charAt(j);
                // 직전 문자와 현재 문자가 다르면 나온 적 있는지 체크
                if (j > 0 && currentChar != targetString.charAt(j-1) && countingArray[currentChar]) {
                    isGroupWord = false;
                    break;
                }
                countingArray[currentChar] = true;
            }

            if (isGroupWord) {
                count++;
            }
        }

        System.out.println(count);
    }
}
