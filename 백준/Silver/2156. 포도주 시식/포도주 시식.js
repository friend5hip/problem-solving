const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf8")
    .trim()
    .split("\n");

const n = +input[0];
const wines = input.slice(1).map(Number);

const dp = Array(n).fill(0);
dp[0] = wines[0];
dp[1] = wines[0] + wines[1];
dp[2] = Math.max(dp[1], wines[0] + wines[2], wines[1] + wines[2]);

if (n === 1) {
    console.log(dp[0]);
    return;
} else if (n === 2) {
    console.log(dp[1]);
    return;
}

for (let i = 3; i < n; i++) {
    dp[i] = Math.max(dp[i - 1], dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i]);
}

console.log(Math.max(...dp));