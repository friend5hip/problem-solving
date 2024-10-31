import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        StringBuilder st = new StringBuilder();
        int i = 0;
        while (i < A.length()) {
            int cnt = 0;
            while (i != A.length() - 1 && A.charAt(i) == A.charAt(i + 1)) {
                cnt++;
                i++;
            }
            st.append(A.charAt(i));
            st.append(cnt + 1);
            i++;
        }
        System.out.println(st.length());
        System.out.println(st);
    }
}