const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf-8")
    .trim()
    .split("\n")

const [n, s] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let count = 0;
function dfs(depth, current) {
    if (depth === n) {
        if (current === s) count++;
        return;
    }

    dfs(depth + 1, current + arr[depth]);
    dfs(depth + 1, current);
}

dfs(0, 0);
if (s === 0) count--;
console.log(count);
