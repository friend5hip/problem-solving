import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (a < 11 || (b < 11 || c < 11)) {
            System.out.print(-1);
        } else {
            int elapsedMinute = 0;
            // 시작 날짜, 시간
            int day = 11;
            int hour = 11;
            int minute = 11;
            while (true) {
                // 목표 시간이 되면 반복 종료
                if (day == a && hour == b && minute == c) {
                    break;
                }

                elapsedMinute++;
                minute++;

                if (minute > 60) {
                    hour++;
                    minute = 1;
                }
                if (hour > 24) {
                    day++;
                    hour = 1;
                }
            }

            System.out.print(elapsedMinute);
        }
    }
}