const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n")

const n = +input[0];
const triangle = input.slice(1).map(line => line.split(" ").map(Number));

for (let i = 1; i < n; i++) {
    for (let j = 0; j <= i; j++) {
        if (j === 0) {
            triangle[i][j] += triangle[i - 1][j];
        } else if (j === i) {
            triangle[i][j] += triangle[i - 1][j - 1];
        } else {
            triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
        }
    }
}

console.log(Math.max(...triangle[n-1]));