const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf-8")
    .trim()
    .split("\n")

const n = +input[0];
const council = input.slice(1).map(e => e.split(" ").map(Number));

let max = 0;
function dfs(day, profit) {
    if (day >= n) {
        max = Math.max(max, profit);
        return
    }

    const [t, p] = council[day];
    if (day + t <= n) {
        dfs(day + t, profit + p);
    }
    dfs(day + 1, profit);
}

dfs(0, 0);
console.log(max);
