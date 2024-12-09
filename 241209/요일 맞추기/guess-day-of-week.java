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
        String[] reversedDayOfTheWeek = {"Mon", "Sun", "Sat", "Fri", "Thu", "Wed", "Tue"};
        int[] endOfTheMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int elapsedDays = 0;
        String theDay = "";
        while (true) {
            // 같은 날짜일 경우 월요일을 출력하고 좌우 날짜가 동일해지면 반복문 탈출
            if (m1 == m2 && d1 == d2 && elapsedDays == 0) {
                theDay = dayOfTheWeek[0];
                break;
            } else if (m1 == m2 && d1 == d2) {
                break;
            }

            elapsedDays++;

            // 만약 오른쪽 날짜가 앞선 날짜라면
            if (m1 > m2 || (m1 == m2 && d1 > d2)) {
                d1--;
                // 1일 보다 작아질 경우 전 달의 마지막 날짜로 갱신
                if (d1 < 1) {
                    m1--;
                    d1 = endOfTheMonth[m1];
                }
                theDay = reversedDayOfTheWeek[elapsedDays % 7];
            // 만약 왼쪽 날짜가 앞선 날짜라면
            } else if (m1 < m2 || (m1 == m2 && d1 < d2)) {
                d1++;
                // 해당 월의 마지막 날짜를 넘어가면 날짜를 1일로 갱신 
                if (d1 > endOfTheMonth[m1]) {
                    m1++;
                    d1 = 1;
                }
                theDay = dayOfTheWeek[elapsedDays % 7];
            }
        }

        System.out.println(theDay);
    }
}