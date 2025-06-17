function solution(n) {
    var answer = [];
    answer = [...Array(n)].map((_, i) => i + 1)
        .filter((num) => num % 2 != 0);
    return answer;
}