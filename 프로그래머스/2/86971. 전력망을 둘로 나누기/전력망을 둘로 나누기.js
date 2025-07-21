function solution(n, wires) {
    let min = Infinity;
    let v1 = 0;
    let v2 = 0;
    const adjacentList = Array.from({ length: n + 1 }, () => []);
    for (const [from, to] of wires) {
        adjacentList[from].push(to);
        adjacentList[to].push(from);
    }

    function dfs(node, blocked, visited) {
        visited[node] = true;
        let count = 1;
        for (const next of adjacentList[node]) {
            if (!visited[next] && next !== blocked) {
                count += dfs(next, blocked, visited);

            }
        }
        return count;
    }
    
    for (const [from, to] of wires) {
        const visited = Array(n + 1).fill(false);
        v1 = dfs(from, to, visited);
        v2 = dfs(to, from, visited);
        const sub = Math.abs(v1 - v2);
        min = Math.min(sub, min);
    }
    
    return min;
}