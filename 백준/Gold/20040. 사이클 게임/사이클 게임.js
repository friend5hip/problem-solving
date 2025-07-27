const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")

const [n, m] = input[0].split(" ").map(Number);
const p = Array(n).fill(0).map((_, i) => i);
let cycled = 0;

for (let i = 0; i < m; i++) {
    const [a, b] = input[i + 1].split(" ").map(Number);
    if (find(a) === find(b)) {
        cycled = i + 1;
        break;
    } else {
        union(a, b);
    }
}

console.log(cycled);

function find(x) {
    if (p[x] === x) return x;
    return p[x] = find(p[x]);
}

function union(u, v) {
    u = find(u);
    v = find(v);
    if (u === v) return;
    if (u < v) p[v] = u;
    else p[u] = v;
}