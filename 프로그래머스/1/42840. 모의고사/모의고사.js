function solution(answers) {
    const first = [1, 2, 3, 4, 5];
    const second = [2, 1, 2, 3, 2, 4, 2, 5];
    const third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

    const count = [0, 0, 0];

    for (let i = 0; i < answers.length; i++) {
        if (answers[i] === first[i % first.length]) count[0]++;
        if (answers[i] === second[i % second.length]) count[1]++;
        if (answers[i] === third[i % third.length]) count[2]++;
    }

    const max = Math.max(...count);
    const result = [];

    for (let i = 0; i < 3; i++) {
        if (count[i] === max) result.push(i + 1);
    }

    return result;
}
