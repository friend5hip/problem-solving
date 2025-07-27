const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n");

const [n, q] = input[0].split(" ").map(Number);
const woods = input.slice(1, 1 + n).map((e, i) => {
    const [x1, x2, y] = e.split(" ").map(Number);
    return { x1, x2, y, id: i + 1 };
});
woods.sort((a, b) => a.x1 - b.x1);
const queries = input.slice(1 + n, 1 + n + q).map(e => e.split(" ").map(Number));
const p = Array(n + 1).fill(0).map((_, i) => i);
const result = [];

let groupId = woods[0].id;
let maxX2 = woods[0].x2;

for (let i = 1; i < n; i++) {
    const current = woods[i];
    if (current.x1 <= maxX2) {
        union(groupId, current.id);
        maxX2 = Math.max(maxX2, current.x2);
    } else {
        groupId = current.id;
        maxX2 = current.x2;
    }
}

for (const [a, b] of queries) {
    if (find(a) === find(b)) result.push(1);
    else result.push(0);
}

console.log(result.join("\n"));

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