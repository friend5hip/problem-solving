const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")

const n = +input[0];
const m = +input[1];
const map = input.slice(2, 2 + n).map(e => e.split(" ").map(Number));
const path = input[2 + n].split(" ").map(Number);

const p = Array.from({ length: n + 1 }, (_, i) => i);

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        if (map[i][j] === 1) {
            union(i + 1, j + 1);
        }
    }
}

const root = find(path[0]);
const isPossible = path.every(city => find(city) === root);

console.log(isPossible ? "YES" : "NO");

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