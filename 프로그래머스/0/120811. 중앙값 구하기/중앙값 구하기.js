function solution(array) {
    var answer = 0;
    const newArr = [...array].sort((a, b) => a - b);
    answer = newArr[Math.floor((newArr.length) / 2)];
    return answer;
}