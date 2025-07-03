const [n, line] = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n")

const N = +n;
const arr = line.split(" ").map(Number);

const dp1 = Array(N).fill(0); // 제거하지 않은 경우의 최대 연속합
const dp2 = Array(N).fill(0); // 하나를 제거한 경우의 최대 연속합
dp1[0] = arr[0]; 
dp2[0] = 0;

let max = dp1[0];

for (let i = 1; i < n; i++) {
    dp1[i] = Math.max(dp1[i - 1] + arr[i], arr[i]); // 선택 or 새로 시작
    dp2[i] = Math.max(dp1[i - 1], dp2[i - 1] + arr[i]); // 제거 or 선택(제거한 최대 연속합에서)
    max = Math.max(max, dp1[i], dp2[i]);
}

console.log(max);