const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n");

const MAX_SIZE = 1000001;
const n = +input[0];
const p = Array.from({ length: MAX_SIZE }, (_, i) => i);
const size = Array(MAX_SIZE).fill(1);
const result = [];

for (let i = 0; i < n; i++) {
  const query = input[i + 1].split(" ");
  const instruction = query[0];
  if (instruction === "I") {
    union(Number(query[1]), Number(query[2]));
  } else {
    const root = find(Number(query[1]));
    result.push(size[root]);
  }
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
  if (size[u] < size[v]) {
    p[u] = v;
    size[v] += size[u];
  }
  else {
    p[v] = u; 
    size[u] += size[v];
  }
}