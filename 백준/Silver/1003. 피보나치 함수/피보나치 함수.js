const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const T = +input[0];
const n = input.slice(1).map(Number);

const dp = Array(41).fill(0);
dp[0] = [1, 0];
dp[1] = [0, 1];

for (let i = 2; i <= 40; i++) {
    const [a, b] = dp[i - 1];
    const [c, d] = dp[i - 2];
    dp[i] = [a + c, b + d];
}

for (let t = 0; t < T; t++) {
    console.log(dp[n[t]][0], dp[n[t]][1]);
}