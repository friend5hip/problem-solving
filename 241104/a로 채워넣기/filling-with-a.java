import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        char[] charArr = str.toCharArray();
        charArr[1] = 'a';
        charArr[charArr.length - 2] = 'a';
        str = String.valueOf(charArr);

        System.out.print(str);
    }
}