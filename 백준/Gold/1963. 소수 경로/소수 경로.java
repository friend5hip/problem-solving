import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, target));
        }
    }

    public static String bfs(int start, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            int currentNumber = queue.poll();
            String numToStr = String.valueOf(currentNumber);

            if (currentNumber == target) {
                return String.valueOf(visited.get(currentNumber));
            }
            // 모든 자릿수에 대해 체크
            for (int i = 0; i < 4; i++) {
                String prefix = numToStr.substring(0, i); // 현재 자릿수의 앞자리 숫자
                String suffix = numToStr.substring(i + 1); // 현재 자릿수의 뒷자리 숫자
                // 0~9까지 넣어보기
                for (int j = 0; j < 10; j++) {
                    if (j == 0 && i == 0) continue; // 자릿수가 같은 경우
                    if (j == Character.getNumericValue(numToStr.charAt(i))) continue; // 같은 숫자일 경우

                    int nextNumber = Integer.parseInt(prefix + j + suffix);
                    if (isPrime(nextNumber) && !visited.containsKey(nextNumber)) {
                        visited.put(nextNumber, visited.get(currentNumber) + 1);
                        queue.add(nextNumber);
                    }
                }
            }
        }
        return "Impossible";
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
