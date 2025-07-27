const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")

const [n, m] = input[0].split(" ").map(Number);
const ops = input.slice(1).map(e => e.split(" ").map(Number));

const p = Array(n + 1).fill(0).map((_, i) => i);

const result = [];

for (const [op, a, b] of ops) {
    if (op === 0){
        union(a, b);
    } else {
        if (isUnion(a, b)) {
            result.push("YES");
        } else {
            result.push("NO")
        }
    }
}

console.log(result.join("\n"));

function find(x) {
    if (p[x] === x) return x;
    return p[x] = find(p[x]);
}

function union(a, b) {
    a = find(a);
    b = find(b);
    if (a === b) return;
    if (a < b) p[b] = a;
    else p[a] = b;
}

function isUnion(a, b) {
    a = find(a);
    b = find(b);
    if (a === b) return true;
    return false;
}