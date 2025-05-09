import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String str1 = st.nextToken().replace(":", " ");
            StringTokenizer st1 = new StringTokenizer(str1);
            int[] startTime = new int[3];
            startTime[0] = Integer.parseInt(st1.nextToken());
            startTime[1] = Integer.parseInt(st1.nextToken());
            startTime[2] = Integer.parseInt(st1.nextToken());

            String str2 = st.nextToken().replace(":", " ");
            StringTokenizer st2 = new StringTokenizer(str2);
            int[] endTime = new int[3];
            endTime[0] = Integer.parseInt(st2.nextToken());
            endTime[1] = Integer.parseInt(st2.nextToken());
            endTime[2] = Integer.parseInt(st2.nextToken());

            int count = 0;
            String end = String.valueOf(endTime[0]) + endTime[1] + endTime[2];
            if (endTime[1] < 10) end = endTime[0] + "0" + endTime[1] + endTime[2];
            if (endTime[2] < 10) end = String.valueOf(endTime[0]) + endTime[1] + "0" + endTime[2];
            if (Integer.parseInt(end) % 3 == 0) count++;

            while (startTime[0] != endTime[0] || startTime[1] != endTime[1] || startTime[2] != endTime[2]) {
                String current = String.valueOf(startTime[0]) + startTime[1] + startTime[2];
                if (startTime[1] < 10) current = startTime[0] + "0" + startTime[1] + startTime[2];
                if (startTime[2] < 10) current = String.valueOf(startTime[0]) + startTime[1] + "0" + startTime[2];
                if (Integer.parseInt(current) % 3 == 0) count++; // 현재 수가 3의 배수면 카운트

                startTime[2]++;
                if (startTime[2] > 59) {
                    startTime[1]++;
                    startTime[2] = 0;
                }
                if (startTime[1] > 59) {
                    startTime[0]++;
                    startTime[1] = 0;
                }
                if (startTime[0] > 23) {
                    startTime[0] = 0;
                    startTime[1] = 0;
                    startTime[2] = 0;
                }
            }

            System.out.println(count);
        }
    }
}
