import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            words[i] = word;
        }
        Arrays.sort(words);
        for (int i = 0; i < n; i++) {
            System.out.println(words[i]);
        }
    }
}