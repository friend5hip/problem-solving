import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                temp.append(str.charAt(j));
                set.add(String.valueOf(temp));
            }
        }
        System.out.println(set.size());
    }
}