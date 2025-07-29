const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")

const [n, m] = input[0].split(" ");
const map = input.slice(1).map(e => e.split("").map(Number));
const visited = Array.from({ length: n }, () => Array.from({ length: m }, () => Array(2).fill(false)));
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

console.log(bfs());

function bfs() {
    const q = [];
    q.push([0, 0, 0, 1]);
    visited[0][0][0] = true;

    let head = 0;
    while (q.length > head) {
        const [x, y, wallBroken, dist] = q[head++];

        if (x === n - 1 && y === m - 1) return dist;

        for (let i = 0; i < 4; i++) {
            const nx = x + dx[i];
            const ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (map[nx][ny] === 0 && !visited[nx][ny][wallBroken]) {
                visited[nx][ny][wallBroken] = true;
                q.push([nx, ny, wallBroken, dist + 1]);
            } else if (map[nx][ny] === 1 && wallBroken === 0 && !visited[nx][ny][1]) {
                visited[nx][ny][1] = true;
                q.push([nx, ny, 1, dist + 1]);
            }
        }
    }

    return -1;
}