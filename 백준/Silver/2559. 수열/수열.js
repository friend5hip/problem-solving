const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf-8")
    .trim()
    .split("\n");

const [n, k] = input[0].split(" ").map(Number);
const sequence = input[1].split(" ").map(Number);

const prefix = [sequence[0]];
for (let i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + sequence[i];
}
const sum = (l, r) => l === 0 ? prefix[r] : prefix[r] - prefix[l - 1];

let max = -Infinity;
for (let i = 0; i <= n - k; i++) {
    max = Math.max(sum(i, i + k - 1), max);
}

console.log(max);