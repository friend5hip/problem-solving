const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const n = +input[0];
const board = input.slice(1).map(e => e.split(" ").map(Number));
const visited = Array(n).fill(false);
let min = Infinity;

dfs(0, 0);

console.log(min);

function dfs(depth, index) {
    if (depth === n / 2) {
        const startTeam = [];
        const linkTeam = [];
        for (let i = 0; i < n; i++) {
            if (!visited[i]) linkTeam.push(i);
            else startTeam.push(i);
        }
        let current = calculateAbility(startTeam);
        let rest = calculateAbility(linkTeam);
        min = Math.min(min, Math.abs(current - rest));
        return;
    }

    for (let i = index; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}

function calculateAbility(team) {
    let sum = 0;
    for (let i = 0; i < team.length; i++) {
        for (let j = i + 1; j < team.length; j++) {
            const a = team[i], b = team[j];
            sum += board[a][b] + board[b][a];
        }
    }
    return sum;
}
