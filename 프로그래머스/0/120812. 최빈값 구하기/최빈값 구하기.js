function solution(array) {
    var answer = 0;
    const map = new Map();
    for (const num of array) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    const sorted = [...map.entries()].sort((a, b) => b[1] - a[1])
    if (sorted.length > 1 && sorted[0][1] === sorted[1][1]) return -1;
    answer = sorted[0][0];
    return answer;
}