function solution(array, commands) {
    const answer = [];
    for (const [i, j ,k] of commands) {
        const temp = [];
        for (let e = i; e <= j; e++) {
            temp.push(array[e - 1]);
        }
        temp.sort((a, b) => a - b);
        answer.push(temp[k - 1]);
    }
    return answer;
}