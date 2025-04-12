import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (n == 1) {
                System.out.println(str);
                return;
            }
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        System.out.println(list.get(0).getKey());
    }
}