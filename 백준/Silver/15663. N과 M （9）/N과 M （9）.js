const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number).sort((a, b) => a - b);
const visited = Array(n).fill(false);
const result = [];
const set = new Set();

function dfs(current) {
    if (current.length === m) {
        const seq = current.join(" ");
        if (!set.has(seq)) {
            set.add(seq);
            result.push(seq);
        }
        return;
    }

    for (let i = 0; i < n; i++) {
        if (!visited[i]) {
            visited[i] = true;
            current.push(arr[i]);
            dfs(current);
            current.pop();
            visited[i] = false;
        }
    }
}

dfs([], 0);
console.log(result.join("\n"));