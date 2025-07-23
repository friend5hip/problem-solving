const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const n = +input[0];
const cols = Array(n).fill(false);
const diag1 = Array(2 * n - 1).fill(false);
const diag2 = Array(2 * n - 1).fill(false);
let count = 0;

function backtrack(row) {
    if (row === n) {
        count++;
        return;
    }

    for (let col = 0; col < n; col++) {
        if (!cols[col] && !diag1[row + col] && !diag2[row - col + (n - 1)]) {
            cols[col] = diag1[row + col] = diag2[row - col + (n - 1)] = true;
            backtrack(row + 1);
            cols[col] = diag1[row + col] = diag2[row - col + (n - 1)] = false;
        }
    }
}

backtrack(0);
console.log(count);