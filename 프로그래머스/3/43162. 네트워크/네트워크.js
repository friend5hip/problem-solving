let visited;
let adjacentMatrix;

function solution(n, computers) {
    let count = 0;
    adjacentMatrix = computers;
    visited = Array(n).fill(false);
    
    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            dfs(i);
            count++;
        }
    }
    
    return count;
}

function dfs(node) {
    visited[node] = true;
        
    for (let i in adjacentMatrix) {
        if (!visited[i] && adjacentMatrix[node][i] === 1) {
            dfs(i);
        }
    }
}