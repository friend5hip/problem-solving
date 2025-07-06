const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];

let count = 0;
let start = 1;
let end = 1;
let sum = 1;
while (start <= n) {
    if (sum === n) count++;

    if (sum > n) {
        sum -= start;
        start++;
    } else {
        end++;
        sum += end;
    }
}

console.log(count);