const fs = require("fs");
const input = fs
  .readFileSync(
    process.platform === "linux" ? "/dev/stdin" : "input.txt",
    "utf-8"
  )
  .trim()
  .split("\n");

const s = input[0];
const q = Number(input[1]);
const queries = input.slice(2).map((line) => {
  const [a, l, r] = line.split(" ");
  return [a, Number(l), Number(r)];
});

const toIndex = (c) => c.charCodeAt(0) - 97;

const prefix = Array.from({ length: s.length }, () => Array(26).fill(0));
prefix[0][toIndex(s[0])] = 1;

for (let i = 1; i < s.length; i++) {
  for (let c = 0; c < 26; c++) {
    prefix[i][c] = prefix[i - 1][c];
  }
  prefix[i][toIndex(s[i])] += 1;
}

const sum = (char, l, r) => {
  const idx = toIndex(char);
  if (l === 0) return prefix[r][idx];
  return prefix[r][idx] - prefix[l - 1][idx];
};

let output = [];
for (const [a, l, r] of queries) {
  output.push(sum(a, l, r));
}

console.log(output.join("\n"));