function solution(answers) {
    const first = [1, 2, 3, 4, 5];
    const second = [2, 1, 2, 3, 2, 4, 2, 5];
    const third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    const count = new Map();
    for (let i = 0; i < answers.length; i++) {
        const answer = answers[i];
        if (first[i % 5] === answer) count.set(1, (count.get(1) || 0) + 1);
        if (second[i % 8] === answer) count.set(2, (count.get(2) || 0) + 1);
        if (third[i % 10] === answer) count.set(3, (count.get(3) || 0) + 1);
    }
    
    const sorted = [...count.entries()].sort((a, b) => {
        if (a[1] === b[1]) return a[0] - b[0];
        return b[1] - a[1];
    });
    
    let max = sorted[0][1];
    const answer = [];
    for (let [i, c] of sorted) {
        if (max === c) answer.push(i);
    }
    return answer;
}