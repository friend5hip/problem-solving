import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                temp.append(str.charAt(j));
                map.put(String.valueOf(temp), map.getOrDefault(String.valueOf(temp), 0) + 1);
            }
        }
        System.out.println(map.size());
    }
}