const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n")

const test = Number(input[0]);
let idx = 1;
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

for (let t = 0; t < test; t++) {
    const [h, w] = input[idx++].split(" ").map(Number);
    const map = input.slice(idx, idx + h).map(line => line.split(""));
    idx += h;
    const keys = input[idx++];

    let answer = bfs(h, w, keys, map)
    console.log(answer);
}

function bfs(h, w, keys, map) {
    const visited = Array.from({ length : h }, () => Array(w).fill(false));
    const q = [];
    const keySet = new Set(keys === "0" ? [] : keys.split(""));
    const doors = {};
    let docs = 0;

    // 가장자리 좌표를 모두 큐에 삽입
    for (let i = 0; i < h; i++) {
        for (let j = 0; j < w; j++) {
            if ((i === 0 || i === h - 1 || j === 0 || j === w - 1) 
                && map[i][j] !== '*') {
                q.push([i, j]);
                visited[i][j] = true;
            }
        }
    }
    
    while (q.length > 0) {
        const [x, y] = q.shift();
        const cell = map[x][y];

        // 문서일 때
        if (cell === "$") {
            docs++;
            map[x][y] = '.';
        }

        // 열쇠일 때
        if ("a" <= cell && cell <= "z") {
            if (!keySet.has(cell)) {
                keySet.add(cell);
                const upper = cell.toUpperCase();
                if (doors[upper]) {
                    for (const [dx, dy] of doors[upper]) {
                        q.push([dx, dy]);
                        visited[dx][dy] = true;
                    }
                }
            }
        }

        // 문일 때
        if ("A" <= cell && cell <= "Z") {
            // 열쇠가 없으면 좌표를 저장만 해둔다.
            if (!keySet.has(cell.toLowerCase())) {
                doors[cell] ??= [];
                doors[cell].push([x, y]);
                continue;
            }
        }

        for (let d = 0; d < 4; d++) {
            const nx = x + dx[d];
            const ny = y + dy[d];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] === "*") continue;

            q.push([nx, ny]);
            visited[nx][ny] = true;
        }
    }

    return docs;
}