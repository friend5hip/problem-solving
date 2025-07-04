const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];
const a = input[1].split(" ").map(Number);

const dp = Array(n).fill(0);
dp[0] = a[0];

let max = a[0];
for (let i = 1; i < n; i++) {
    dp[i] = a[i];
    for (let j = 0; j < i; j++) {
        if (a[i] > a[j]) {
            dp[i] = Math.max(dp[i], dp[j] + a[i]);
        }
    }
    max = Math.max(max, dp[i]);
}

console.log(max);