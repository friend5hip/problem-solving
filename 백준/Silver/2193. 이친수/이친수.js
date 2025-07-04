const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];

const dp = Array(n + 1).fill(0);
dp[1] = 1; // 1
dp[2] = 1; // 10
dp[3] = 2; // 100, 101

for (let i = 4; i <= n; i++) {
    dp[i] = BigInt(dp[i - 1]) + BigInt(dp[i - 2]);
}

console.log(dp[n].toString());