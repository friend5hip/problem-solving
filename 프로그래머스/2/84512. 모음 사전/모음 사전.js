function solution(word) {
    let count = 0;
    let flag = false;
    const vowel = ["A", "E", "I", "O", "U"];
    
    function dfs(current, vowel) {
        if (current.join("") === word) {
            flag = true;
        }
        
        for (let i = 0; i < 5; i++) {
            if (!flag && current.length < 5) {
                current.push(vowel[i]);
                dfs(current, vowel);
                count++;
                current.pop();
            }
        }
    }
    
    dfs([] , vowel, 1);
    
    return count;
}