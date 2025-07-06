const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const [n, m] = input[0].split(" ");
const a = input.slice(1).map(Number).sort((a, b) => a - b);

let start = 0;
let end = 0;
let min = Infinity;
while (end < n) {
    let diff = a[end] - a[start];
    if (diff >= m) {
        min = Math.min(min, diff);
        start++;
    } else {
        end++;
    }
}

console.log(min);