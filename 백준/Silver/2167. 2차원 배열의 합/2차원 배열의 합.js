const input = require("fs")
  .readFileSync(
    process.platform === "linux" ? "/dev/stdin" : "input.txt",
    "utf-8",
  )
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const grid = input.slice(1, n + 1).map((line) => line.split(" ").map(Number));
const k = Number(input[n + 1]);
const points = input
  .slice(n + 2, n + 2 + k)
  .map((line) => line.split(" ").map(Number));

const prefix = Array.from({ length: n + 1 }, () => Array(m + 1).fill(0));
for (let i = 1; i <= n; i++) {
  for (let j = 1; j <= m; j++) {
    prefix[i][j] =
      grid[i - 1][j - 1] +
      prefix[i - 1][j] +
      prefix[i][j - 1] -
      prefix[i - 1][j - 1];
  }
}

const sum = ([x1, y1, x2, y2]) => {
  return (
    prefix[x2][y2] -
    prefix[x1 - 1][y2] -
    prefix[x2][y1 - 1] +
    prefix[x1 - 1][y1 - 1]
  );
};

let answer = [];
for (const point of points) {
  answer.push(sum(point));
}

console.log(answer.join("\n"));