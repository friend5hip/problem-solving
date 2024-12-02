import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 공백없는 두개의 문자열을 입력 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str1 = st.nextToken();
        String str2 = st.nextToken();

        System.out.print(Integer.parseInt(eliminateNaN(str1)) + Integer.parseInt(eliminateNaN(str2)));
    }

    // 문자열에서 숫자가 아닌 부분 제거
    public static String eliminateNaN(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            int target = chars[i];
            if ((target >= 65 && target <= 90) || (target >= 97 && target <= 122)) {
                chars[i] = ' ';
            }
        }
        String result = String.valueOf(chars);
        result = result.replaceAll(" ", "");
        return result;
    }
}