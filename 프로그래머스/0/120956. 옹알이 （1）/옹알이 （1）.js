function solution(babbling) {
    var answer = 0;
    const canPronounce = ["aya", "ye", "woo", "ma"];
    for (const word of babbling) {
        let current = word;
        for (const four of canPronounce) {
            current = current.replaceAll(four, 1);
        }
        isValid = true;
        for (const one of current) {
            if (one != 1) isValid = false; 
        }
        if (isValid) answer++;
        console.log(current);
    }
    return answer;
}