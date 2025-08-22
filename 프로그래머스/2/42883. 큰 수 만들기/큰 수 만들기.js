function solution(number, k) {
    const stack = [];
    
    for (let i = 0; i < number.length; i++) {
        const current = number[i];
        while (k > 0 && stack.length > 0 && stack[stack.length - 1] < current) {
            stack.pop();
            k--;
        }
        stack.push(current);
    }
    
    for (let i = k; k > 0; k--) {
        stack.pop();
    }
    
    return stack.join("");
}