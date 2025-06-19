const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf-8")
    .trim()
    .split("\n");

const [n, m, v] = input[0].split(" ").map(Number);
const graph = Array.from({ length: n + 1}, () => [])
for (let i = 1; i <= m; i++) {
    const [from, to] = input[i].split(" ").map(Number);
    graph[from].push(to);
    graph[to].push(from);
}

for (let i = 1; i <= n; i++) {
    graph[i].sort((a, b) => a - b);
}

const visitedDfs = Array(n).fill(false);
const pathDfs = [v];
function dfs(node) {
    visitedDfs[node] = true;
    
    for (const next of graph[node]) {
        if (!visitedDfs[next]) {
            pathDfs.push(next);
            dfs(next);
        }
    }
}


dfs(v);
console.log(pathDfs.join(" "));

const visitedBfs = Array(n).fill(false);
const pathBfs = [];
function bfs(node) {
    const q = [node];
    visitedBfs[node] = true;
    
    while (q.length > 0) {
        const next = q.shift();
        pathBfs.push(next);
        
        for (const to of graph[next]) {
            if (!visitedBfs[to]) {
                visitedBfs[to] = true;
                q.push(to);
            }
        }
     
    }
}

bfs(v);
console.log(pathBfs.join(" "));
