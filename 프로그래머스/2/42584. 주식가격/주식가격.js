function solution(prices) {
    const answer = Array(prices.length).fill(0);
    const stack = [];
    
    for (let i = 0; i < prices.length; i++) {
        while (stack.length > 0 && prices[i] < prices[stack[stack.length - 1]]) {
            const decreased = stack.pop();
            answer[decreased] = i - decreased;
        }
        stack.push(i);
    }
    
    while (stack.length > 0) {
        const neverDecreased = stack.pop();
        answer[neverDecreased] = prices.length - neverDecreased - 1;
    }
    
    return answer;
}