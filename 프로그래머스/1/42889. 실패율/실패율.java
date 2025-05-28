import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 현재 스테이지를 도전중인 플레이어 수를 계산한다.
        int[] currentUsers = new int[N + 2]; // 1 ~ N + 1까지 클리어한 사용자 수
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
                totalPlayers -= currentUsers[i]; // 다음 스테이지로 넘어간 사람만 남긴다.
            }
        }

        stageInfos.sort((a, b) -> {
            if (Double.compare(b.failureRate, a.failureRate) != 0) {
                return Double.compare(b.failureRate, a.failureRate); // 실패율을 기준으로 내림차순 정렬
            }
            return Integer.compare(a.stage, b.stage); // 스테이지 번호를 기준으로 오름차순 정렬
        });

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = stageInfos.get(i).stage;
        }

        return result;
    }
    
    static class StageInfo {
        int stage;
        double failureRate;

        StageInfo(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }
}
