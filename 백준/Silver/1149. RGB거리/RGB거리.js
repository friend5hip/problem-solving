const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n")

const n = +input[0];
const rgbs = input.slice(1).map(l => l.split(" ").map(Number));

const dp = Array.from({ length: n }, () => Array(3).fill());
dp[0][0] = rgbs[0][0];
dp[0][1] = rgbs[0][1];
dp[0][2] = rgbs[0][2];

for (let i = 1; i < n; i++) {
    for (let j = 0; j < 3; j++) {
        if (j === 0) {
            dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgbs[i][j];
        } else if (j === 1) {
            dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgbs[i][j];
        } else {
            dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + rgbs[i][j];
        }
    }
}

console.log(Math.min(...dp[n - 1]));