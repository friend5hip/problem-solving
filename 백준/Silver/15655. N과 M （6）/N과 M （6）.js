const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number).sort((a, b) => a - b);
const result = [];

function dfs(current, index) {
    if (current.length === m) {
        result.push(current.join(" "));
        return;
    }

    for (let i = index; i < n; i++) {
        current.push(arr[i]);
        dfs(current, i + 1);
        current.pop();
    }
}

dfs([], 0);
console.log(result.join("\n"));