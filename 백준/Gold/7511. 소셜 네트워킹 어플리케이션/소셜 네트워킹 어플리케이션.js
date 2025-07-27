const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n")

let line = 0;
let index = 1;
let t = +input[line++];

while (t-- > 0) {
    const result = [];
    const n = +input[line++];
    const p = Array(n).fill(0).map((_, i) => i);
    const k = +input[line++];
    const friends = input.slice(line, line + k).map(e => e.split(" ").map(Number));
    line += k;
    const m = +input[line++];
    const relations = input.slice(line, line + m).map(e => e.split(" ").map(Number));
    line += m;

    for (const [a, b] of friends) union(a, b);

    for (const [a, b] of relations) {
        if (isUnion(a, b)) result.push(1);
        else result.push(0);
    }

    console.log(`Scenario ${index}: \n` + result.join("\n") + "\n");
    index++;

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

    function isUnion(u, v) {
        u = find(u);
        v = find(v);
        if (u === v) return true;
        return false;
    }
}