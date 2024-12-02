import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long minResult = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 점의 개수
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }

        // 결과 출력
        System.out.println(getMinDistanceSum(points));
    }

    public static long getMinDistanceSum(int[] points) {
        int n = points.length;
        if (n == 0) return 0;

        minResult = Long.MAX_VALUE;
        boolean[] visited = new boolean[n];
        findMinDistanceSum(0, 0, 0, visited, points);
        return minResult;
    }

    private static void findMinDistanceSum(int currentPos, long totalDistance,
                                           long sumOfRecords, boolean[] visited, int[] points) {
        // 모든 점을 방문했는지 확인
        boolean allVisited = true;
        for (boolean v : visited) {
            if (!v) {
                allVisited = false;
                break;
            }
        }

        // 모든 점을 방문했다면 기록된 거리의 합과 최소값 비교
        if (allVisited) {
            minResult = Math.min(minResult, sumOfRecords);
            return;
        }

        // 아직 방문하지 않은 모든 점에 대해 시도
        for (int i = 0; i < points.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                // 현재 위치에서 다음 점까지의 거리 계산
                int distance = Math.abs(points[i] - currentPos);
                // 이 점까지의 총 이동거리 = 이전까지의 총 이동거리 + 새로 이동한 거리
                long newTotalDistance = totalDistance + distance;
                // 이 점에 기록될 거리를 sumOfRecords에 더함
                long newSumOfRecords = sumOfRecords + newTotalDistance;

                // 다음 점으로 이동하여 재귀 호출
                findMinDistanceSum(points[i], newTotalDistance,
                        newSumOfRecords, visited, points);

                // 방문 표시 되돌리기 (백트래킹)
                visited[i] = false;
            }
        }
    }
}
