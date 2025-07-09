function solution(progresses, speeds) {
    const answer = [];

    while (progresses.length > 0) {
        // 개발 진행
        for (let i in progresses) {
            if (progresses[i] < 100) progresses[i] += speeds[i];
        }
        // 맨 앞 기능 개발 완료 체크
        let count = 0;
        while (progresses[0] >= 100) {
            progresses.shift();
            speeds.shift();
            count++;
        }
        if (count > 0) answer.push(count);
    }
    return answer;   
}