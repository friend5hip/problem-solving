function solution(begin, target, words) {
    let min = Infinity;
    let visited = Array(words.length).fill(false);
    
    if (!words.includes(target)) return 0;
    
    function dfs(depth, current) {
        if (current === target) {
            min = Math.min(min, depth);
            return;
        }
        
        for (let i = 0; i < words.length; i++) {
            if (!visited[i] && isNext(current, words[i])) {
                visited[i] = true;
                dfs(depth + 1, words[i]);
                visited[i] = false;
            }
        }
    }
    
    dfs(0, begin);
    return min;
}

function isNext(current, next) {
    let diff = 0;
    for (let i = 0; i < current.length; i++) {
        if (current[i] !== next[i]) diff++;
    }
    return diff === 1;
}