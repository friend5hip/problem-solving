import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // e를 찾으면
        if (str.contains("e")) {
            // e를 제거
            int index = str.indexOf("e");
            str = str.substring(0, index) + str.substring(index + 1, str.length());
        }

        // 출력
        System.out.println(str);
    }
}