import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        StringBuilder sb = new StringBuilder();
        sb.append(str1.substring(0, 2));
        sb.append(str2.substring(2));

        System.out.print(sb.toString());
    }
}