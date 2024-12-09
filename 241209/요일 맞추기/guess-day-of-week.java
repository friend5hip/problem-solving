import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String[] dayOfTheWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        String[] reversedDayOfTheWeek = {"Sun", "Sat", "Fri", "Thu", "Wed", "Tue", "Mon"};
        int[] endOfTheMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int elapsedDays = 0;
        String theDay = "";
        while (true) {
            if (m1 == m2 && d1 == d2) {
                theDay = dayOfTheWeek[0];
                break;
            }

            // 만약 앞의 날짜가 앞선 날짜라면
            if (m1 > m2 || (m1 == m2 && d1 > d2)) {
                d1--;
                if (d1 < 1) {
                    m1--;
                    d1 = endOfTheMonth[m1];
                }
                theDay = reversedDayOfTheWeek[elapsedDays % 7];
            } else if (m1 < m2 || (m1 == m2 && d1 < d2)) {
                d1++;
                if (d1 > endOfTheMonth[m1]) {
                    m1++;
                    d1 = 1;
                }
                theDay = dayOfTheWeek[elapsedDays % 7];
            }
            elapsedDays++;
        }

        System.out.println(theDay);
    }
}