const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const grid = Array.from({ length: n + 1 }, (_, i) => 
    i === 0 ? Array(n + 1).fill(0) : [0, ...input[i].split(" ").map(Number)]
);
    
const points = input
    .slice(n + 1, n + 1 + m)
    .map(line => line.split(" ").map(Number))

const prefix = Array.from({ length: n + 1 }, () => Array(n + 1).fill(0));
for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= n; j++) {
        prefix[i][j] =
          grid[i][j]
        + prefix[i - 1][j]
        + prefix[i][j - 1]
        - prefix[i - 1][j - 1];
    }
}

const sum = (x1, y1, x2, y2) => 
    prefix[x2][y2]
    - prefix[x1 - 1][y2]
    - prefix[x2][y1 - 1]
    + prefix[x1 - 1][y1 - 1];

for (const [x1, y1, x2, y2] of points) {
    console.log(sum(x1, y1, x2, y2));
}