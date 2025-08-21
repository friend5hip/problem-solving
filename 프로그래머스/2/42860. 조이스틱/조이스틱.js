function solution(name) {
    let vertCount = 0;
    let horCount = name.length - 1;
    let foundA = false;
    
    // 세로 조작 횟수 계산
    for (let i = 0; i < name.length; i++) {
        if (name[i] === 'A') foundA = true;
        const index = name[i].charCodeAt(0);
        vertCount += Math.min(index - 'A'.charCodeAt(0), 'Z'.charCodeAt(0) - index + 1);
    }
    
    // 가로 조작 횟수 계산
    if (foundA) {
        for (let i = 0; i < name.length; i++) {
            let nextIndex = i + 1;
            while (nextIndex < name.length && name[nextIndex] === 'A') {
                nextIndex++;
            }
            const right = i * 2 + (name.length - nextIndex);
            const left = i + 2 * (name.length - nextIndex);
            horCount = Math.min(horCount, left, right);
        }
    }

    return vertCount + horCount;
}