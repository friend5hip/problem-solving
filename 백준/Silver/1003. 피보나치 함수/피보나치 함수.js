const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const T = +input[0];
const n = input.slice(1).map(Number);

for (let t = 0; t < T; t++) {
    const dp = Array(n[t] + 1).fill(0);
    dp[0] = [0, 1];
    dp[1] = [1, 0];
    dp[2] = [1, 1];
    dp[3] = [1, 2];

    if (n[t] === 0) {
        console.log(1, 0); 
        continue;
    } else if (n[t] === 1) {
        console.log(0, 1);
        continue;
    } else if (n[t] === 3) {
        console.log(1, 2);
        continue;
    }

    for (let i = 4; i <= n[t]; i++) {
        const [a, b] = dp[i - 1];
        const [c, d] = dp[i - 2];
        dp[i] = [a + c, b + d];
    }

    console.log(dp[n[t]][0], dp[n[t]][1]);
}