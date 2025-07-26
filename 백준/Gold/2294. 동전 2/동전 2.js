const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const [n, k] = input[0].split(" ").map(Number);
const coins = [... new Set(input.slice(1).map(e => Number(e)))];

const dp = Array(k + 1).fill(10001);
dp[0] = 0;

for (let i = 0; i < n; i++) {
    const coin = coins[i];
    for (let j = coin; j <= k; j++) {
        if (dp[j - coin] !== 10001) {
            dp[j] = Math.min(dp[j], dp[j - coin] + 1);
        }
    }
}

console.log(dp[k] === 10001 ? -1 : dp[k]);