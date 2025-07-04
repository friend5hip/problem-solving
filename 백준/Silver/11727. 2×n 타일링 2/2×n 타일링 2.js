const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];

const dp = Array(n).fill(0);
dp[0] = 1;
dp[1] = 3;
dp[2] = 5;

for (let i = 3; i < n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 2]) % 10007;
}

console.log(dp[n - 1]);