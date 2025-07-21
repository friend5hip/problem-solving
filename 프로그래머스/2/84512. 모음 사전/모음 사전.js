function solution(word) {
    let count = 0;
    let flag = false;
    const vowel = ["A", "E", "I", "O", "U"];
    
    function dfs(current) {
        if (current.join("") === word) {
            flag = true;
            return;
        }

        if (current.length === 5) return;
        
        for (let i = 0; i < 5; i++) {
            if (!flag && current.length < 5) {
                current.push(vowel[i]);
                count++;
                dfs(current);
                current.pop();
            }
        }
    }
    
    dfs([]);
    
    return count;
}