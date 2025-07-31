const n = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")
  .map(Number);

const result = [];
for (let i = 1; i <= n; i++) {
    result.push(i);
}

console.log(result.join('\n'));