const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf-8")
    .trim()
    .split('\n')

const t = +input[0];
const n = input.slice(1).map(Number);
const MAX_N = 100;

const dp = Array(MAX_N + 1).fill(0);
dp[1] = 1;
dp[2] = 1;
dp[3] = 1;
dp[4] = 2;
dp[5] = 2;
dp[6] = 3;

for (let i = 7; i <= MAX_N; i++) {
    dp[i] = dp[i - 3] + dp[i - 2];
}

const answer = [];
for (const num of n) {
    answer.push(dp[num]);
}
console.log(answer.join("\n"));
