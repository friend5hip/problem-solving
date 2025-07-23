const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const n = +input[0];
const cols = Array(n).fill(false);
const diag1 = Array(2 * n - 1).fill(false);
const diag2 = Array(2 * n - 1).fill(false);

function backtrack(row) {
    if (row === n) {
        return 1;
    }

    let count = 0;
    for (let col = 0; col < n; col++) {
        if (!cols[col] && !diag1[row + col] && !diag2[row - col + (n - 1)]) {
            cols[col] = diag1[row + col] = diag2[row - col + (n - 1)] = true;
            count += backtrack(row + 1);
            cols[col] = diag1[row + col] = diag2[row - col + (n - 1)] = false;
        }
    }

    return count;
}

console.log(backtrack(0));