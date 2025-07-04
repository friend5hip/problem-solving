const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n")

const T = +input[0];
const n = input.slice(1).map(Number);
const MAX_N = Math.max(...n);

const dp = Array(MAX_N + 1).fill(0);
dp[1] = 1;
dp[2] = 2;
dp[3] = 4;

for (let i = 4; i <= MAX_N; i++) {
    for (let j = 1; j <= 3; j++) {
        dp[i] += dp[i - j] % 1_000_000_009;
    }
}

const answer = [];
for (const num of n) {
    answer.push(dp[num] % 1_000_000_009);
}
console.log(answer.join("\n"));