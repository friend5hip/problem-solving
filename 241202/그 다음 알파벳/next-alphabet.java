import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 영문자 a를 입력받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();

        // a에 1을 더해 다음 문자를 얻는다. (a: 97, z: 122)
        // z를 넘어가면 26을 빼서 z 다음은 a
        int aNext = ((int) a.charAt(0) + 1);
        if (aNext > 122) {
            aNext -= 26;
        }

        // 출력
        System.out.println((char) aNext);
    }

}