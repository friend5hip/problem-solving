import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        ArrayList<Integer> arr = new ArrayList<>(3);
        arr.add(str1.length());
        arr.add(str2.length());
        arr.add(str3.length());

        System.out.print(Collections.max(arr) - Collections.min(arr));
    }
}