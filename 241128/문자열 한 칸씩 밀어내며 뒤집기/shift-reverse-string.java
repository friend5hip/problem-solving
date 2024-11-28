import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 문자열 1개, q개의 요청 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] splitInput = input.split(" ");
        String string = splitInput[0];
        int q = Integer.parseInt(splitInput[1]);

        // q번 반복
        for (int i = 0; i < q; i++) {
            int whichRequest = Integer.parseInt(br.readLine());
            int L = string.length();
            String temporalString = string;
            switch (whichRequest) {
                // 1이면 왼쪽으로 shift
                // 2면 오른쪽으로 shift
                // 3이면 거꾸로 출력
                case 1:
                    temporalString = temporalString.substring(1, L) + temporalString.substring(0, 1);
                    break;
                case 2:
                    temporalString = temporalString.substring(L-1, L) + temporalString.substring(0, L-1);
                    break;
                case 3:
                    StringBuffer sb = new StringBuffer(string);
                    temporalString = sb.reverse().toString();
                    break;
                default:
                    break;
            }
            bw.write(temporalString + "\n");
            string = temporalString;
        }
        bw.flush();
        bw.close();
    }
}