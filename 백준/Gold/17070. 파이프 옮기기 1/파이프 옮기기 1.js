const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")

const n = +input[0];
const house = input.slice(1).map(e => e.split(" ").map(Number));

const dp = Array.from({ length: n }, () => Array.from({ length: n }, () => Array(3).fill(0)));
dp[0][1][0] = 1;

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        if (house[i][j] === 1) continue;
            
        if (j - 1 >= 0) {
            dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][1];
        }
            
        if (i - 1 >= 0) {
            dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2];
        }

        if (i - 1 >= 0 && j - 1 >= 0) {
            if (house[i - 1][j] === 0 && house[i][j - 1] === 0)
                dp[i][j][1] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
        }
    }
}

console.log(dp[n - 1][n - 1][0] + dp[n - 1][n - 1][1] + dp[n - 1][n - 1][2]);