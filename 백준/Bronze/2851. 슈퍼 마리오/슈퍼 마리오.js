const input = require("fs")
  .readFileSync(
    process.platform === "linux" ? "/dev/stdin" : "input.txt",
    "utf-8",
  )
  .trim()
  .split("\n");

const prefix = [+input[0]];
for (let i = 1; i < 10; i++) {
  prefix[i] = +input[i] + prefix[i - 1];
}

let nearest = 100;
let answer = 0;
for (let i = 10; i >= 0; i--) {
  const sub = Math.abs(prefix[i] - 100);
  if (sub < nearest) {
    nearest = sub;
    answer = prefix[i];
  }
}

console.log(answer);
