const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const [R, C] = input[0].split(" ").map(Number);
const board = input.slice(1).map(e => e.split(""));
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];
let max = 0;

function dfs(r, c, visited, count) {
    for (let i = 0; i < 4; i++) {
        const nr = r + dx[i];
        const nc = c + dy[i];
        if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

        const ch = board[nr][nc].charCodeAt(0) - 65;
        if ((visited & (1 << ch)) === 0) {
            dfs(nr, nc, visited | (1 << ch), count + 1);
        }
    }

    max = Math.max(max, count);
}

dfs(0, 0, 1 << (board[0][0].charCodeAt(0) - 65), 1);

console.log(max);
