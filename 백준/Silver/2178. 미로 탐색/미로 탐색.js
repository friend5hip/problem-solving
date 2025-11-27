const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt', 'utf-8')
    .trim()
    .split('\n');

const [n, m] = input[0].split(" ").map(Number);
const map = input.slice(1).map(e => e.split("").map(Number));
const visited = Array.from({ length: n }, () => Array(m).fill(false));
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

function bfs(start, end) {
    const queue = [];
    queue.push([start, end, 1]);
    visited[start][end] = true;
    
    while (queue.length > 0) {
        const [r, c, dist] = queue.shift();

        if (r === n - 1 && c === m - 1) {
            console.log(dist);
            return;
        };

        for (let i = 0; i < 4; i++) {
            const nr = r + dx[i];
            const nc = c + dy[i];
            const nd = dist + 1;
            
            if (nr < 0 || nr >= n || nc < 0 || nc >= m 
                || visited[nr][nc] === true) continue;
            if (map[nr][nc] === 1) {
                visited[nr][nc] = true;
                queue.push([nr, nc, nd]);
            }
        }
    }
}

bfs(0, 0);