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
        dp[i] += dp[i - j] % 1000000009;
    }
}

for (let i = 0; i < T; i++) {
    console.log(dp[n[i]] % 1000000009);
}