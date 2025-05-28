import java.util.*;

class Solution {
    static class StageInfo {
        int stage;
        double failureRate;

        StageInfo(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] currentUsers = new int[N + 2];
        for (int stage : stages) {
            if (stage <= N) currentUsers[stage]++;
        }

        int totalPlayers = stages.length;
        List<StageInfo> stageInfos = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (totalPlayers == 0) {
                stageInfos.add(new StageInfo(i, 0));
            } else {
                double rate = (double) currentUsers[i] / totalPlayers;
                stageInfos.add(new StageInfo(i, rate));
                totalPlayers -= currentUsers[i]; // 다음 스테이지로 넘어간 사람만 남김
            }
        }

        stageInfos.sort((a, b) -> {
            if (Double.compare(b.failureRate, a.failureRate) != 0) {
                return Double.compare(b.failureRate, a.failureRate); // 실패율 내림차순
            }
            return Integer.compare(a.stage, b.stage); // 스테이지 번호 오름차순
        });

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageInfos.get(i).stage;
        }

        return result;
    }
}
