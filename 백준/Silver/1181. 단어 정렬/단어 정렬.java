import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> wordList = new TreeSet<>((a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                return a.compareTo(b);
            }
        });

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            wordList.add(word);
        }

        for (String word : wordList) {
            System.out.println(word);
        }
    }
}