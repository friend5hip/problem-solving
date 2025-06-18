const [first, ...rows] = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n")

const [n, k] = first.split(" ").map(Number);
const map = rows.map(line => [...line.trim()].map(Number));

let visited = Array.from({ length: 2 }, () => Array(n).fill(false));
console.log(bfs(0, 0));

function bfs(startX, startY) {
    const queue = [[startX, startY, 0]];
    visited[startX][startY] = true;

    while (queue.length > 0) {
        const curr = queue.shift();
        const cx = curr[0];
        const cy = curr[1];
        const ct = curr[2];
        
        const moves = [
            [cx, cy + 1],
            [cx, cy - 1],
            [1 - cx, cy + k]
        ]
        for (const [nx, ny] of moves) {
            const nt = ct + 1;

            if (ny < nt) continue;
            if (ny >= n) return 1;
            if (nx < 0 || nx >= 2 || ny < 0 || ny >= n) continue;
            if (!visited[nx][ny] && map[nx][ny] === 1) {
                queue.push([nx, ny, nt]);
                visited[nx][ny] = true;
            }
        }
    }

    return 0;
}