function solution(new_id) {
    var answer = new_id.toLowerCase().
        replace(/[^a-z0-9._-]/g, '');
    answer = answer.split("");
    for (let i = 0; i < answer.length - 1;) {
        if (answer[i] === "." && answer[i + 1] === ".") {
            answer.splice(i, 1);
        } else {
            i++;
        }
    }
    if (answer[0] === ".") answer.shift();
    if (answer[answer.length - 1] === ".") answer.pop();
    if (answer.length === 0) answer.push("a");
    if (answer.length >= 16) {
        answer = answer.slice(0, 15);
        if (answer[answer.length - 1] === ".") answer[answer.length - 1] = ""; 
    }
    while (answer.length < 3) {
        answer.push(answer[answer.length - 1]);
    }
    answer = answer.join("");
    return answer;
}