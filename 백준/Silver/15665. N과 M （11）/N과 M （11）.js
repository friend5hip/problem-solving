const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number).sort((a, b) => a - b);
const result = [];
const set = new Set();

function dfs(current) {
    if (current.length === m) {
        const comb = current.join(" ");
        if (!set.has(comb)) {
            set.add(comb);
            result.push(comb);
        }
        return;
    }

    for (let i = 0; i < n; i++) {
        current.push(arr[i]);
        dfs(current, i);
        current.pop();
    }
}

dfs([]);
console.log(result.join("\n"));