const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];
const boxes = input[1].split(" ").map(Number);

const dp = Array(n + 1).fill(1);

for (let i = 0; i < n; i++) {
    for (let j = 0; j < i; j++) {
        if (boxes[j] < boxes[i]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);
        }
    }
}

console.log(Math.max(...dp));