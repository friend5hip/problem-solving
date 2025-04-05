import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] answer = new int[26];
        Arrays.fill(answer, -1);
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            int index = chars[i] - 'a';
            if (answer[index] == -1) {
                answer[index] += (i+1);
            }
        }

        for (int index : answer) {
            System.out.print(index + " ");
        }
    }
}