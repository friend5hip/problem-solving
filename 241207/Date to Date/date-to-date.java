import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        // 각 월의 마지막 날짜
        int[] endOfDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int elapsedDay = 1;
        
        while (true) {
            if (m1 == m2 && d1 == d2) {
                break;
            }

            elapsedDay++;
            d1++;

            if (d1 > endOfDays[m1]) {
                m1++;
                d1 = 1;
            }
        }

        System.out.println(elapsedDay);
    }
}