const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n")

const t = Number(input[0]);
let idx = 1;
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

for (let i = 0; i < t; i++) {
    const [h, w] = input[idx++].split(" ").map(Number)
    const map = input.slice(idx, idx + h).map(line => line.split(""));
    idx += h;
    const keys = input[idx++];

    let answer = bfs(keys, map, h, w);
    console.log(answer);
}

function bfs(keys, map, h, w) {
    const visited = Array.from({ length: h }, () => Array(w).fill(false));
    const q = [];
    const keySet = new Set(keys === "0" ? [] : keys.split(""));
    const doors = {};
    let docs = 0;

    // 시작점: 가장자리 전부
    for (let i = 0; i < h; i++) {
        for (let j of [0, w - 1]) {
            if (map[i][j] !== '*') {
                q.push([i, j]);
                visited[i][j] = true;
            }
        }
    }
    for (let j = 0; j < w; j++) {
        for (let i of [0, h - 1]) {
            if (map[i][j] !== '*') {
                q.push([i, j]);
                visited[i][j] = true;
            }
        }
    }

    while (q.length > 0) {
        const [x, y] = q.shift();
        const cell = map[x][y];

        // 문서
        if (cell === '$') {
            docs++;
            map[x][y] = '.';
        }

        // 열쇠
        if ('a' <= cell && cell <= 'z') {
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

        // 문
        if ('A' <= cell && cell <= 'Z') {
            if (!keySet.has(cell.toLowerCase())) {
                doors[cell] ??= [];
                doors[cell].push([x, y]);
                continue;
            }
        }

        // 사방 탐색
        for (let d = 0; d < 4; d++) {
            const nx = x + dx[d];
            const ny = y + dy[d];

            if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] === '*') continue;

            visited[nx][ny] = true;
            q.push([nx, ny]);
        }
    }

    return docs;
}