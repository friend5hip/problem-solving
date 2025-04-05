import java.io.*;
import java.util.*;

public class Main {
     static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> words = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) continue;
            if (words.containsKey(word)) {
                words.compute(word, (k, curr) -> curr + 1);
            } else {
                words.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(words.entrySet());
        list.sort((e1, e2) -> {
            int frequent = e2.getValue().compareTo(e1.getValue());
            if (frequent != 0) return frequent;

            int length = Integer.compare(e2.getKey().length(), e1.getKey().length());
            if (length != 0) return length;

            return e1.getKey().compareTo(e2.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            sb.append(entry.getKey() + "\n");
        }
        System.out.println(sb);
    }
}