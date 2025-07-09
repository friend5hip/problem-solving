function solution(progresses, speeds) {
    const progQueue = [...progresses];
    const speedQueue = [...speeds];
    const answer = [];

    while (progQueue.length > 0) {
        // 개발 진행
        for (let i = 0; i < progQueue.length; i++) {
            if (progQueue[i] >= 100) continue;
            progQueue[i] += speedQueue[i];
        }
        // 맨 앞 기능 개발 완료 체크
        let count = 0;
        while (progQueue[0] >= 100) {
            progQueue.shift();
            speedQueue.shift();
            count++;
        }
        if (count > 0) answer.push(count);
    }
    return answer;   
}