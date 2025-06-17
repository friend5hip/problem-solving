function solution(numbers) {
    var answer = 0;
    const sum = numbers.reduce((acc, cur) => acc + cur, 0);
    answer = sum / numbers.length; 
    return answer;
}