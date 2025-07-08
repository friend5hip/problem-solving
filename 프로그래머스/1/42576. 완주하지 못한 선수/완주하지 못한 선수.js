function solution(participant, completion) {
    const pMap = new Map();
    const cMap = new Map();
    for (const player of participant) {
        pMap.set(player, (pMap.get(player) || 0) + 1);
    }
    for (const player of completion) {
        cMap.set(player, (cMap.get(player) || 0) + 1);
    }
    for (const entry of pMap) {
        if (!cMap.has(entry[0])) {
            return entry[0];
        } else {
            if (cMap.get(entry[0]) !== pMap.get(entry[0])) {
                return entry[0];
            }
        }
    }
}
    
// participant가 1명 더 많음
// participant는 동명이인이 있을 수 있어 집합으로 만들 수 없음
// 동명이인 때문에 집합으로 만들기 어렵다..