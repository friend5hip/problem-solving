const [[n], ...rows] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

const A = rows.map(row => row[0]);
const B = rows.map(row => row[1]);
const C = rows.map(row => row[2]);
const D = rows.map(row => row[3]);

const ABMap = new Map();

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    const sum = A[i] + B[j];
    ABMap.set(sum, (ABMap.get(sum) || 0) + 1);
  }
}

let count = 0;

for (let i = 0; i < n; i++) {
  for (let j = 0; j < n; j++) {
    const sum = C[i] + D[j];
    const target = -sum;
    if (ABMap.has(target)) {
      count += ABMap.get(target);
    }
  }
}

console.log(count);