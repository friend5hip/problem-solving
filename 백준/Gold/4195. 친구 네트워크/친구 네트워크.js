const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n");

const t = +input[0];

let p;
let line = 1;
let size = [];
for (let i = 0; i < t; i++) {
    const f = +input[line++];
    const map = new Map();
    let index = 0;
    const friends = input.slice(line, line + f).map(e => {
        const [a, b] = e.trim().split(" ");
        if (!map.has(a)) map.set(a, index++);
        if (!map.has(b)) map.set(b, index++);
        return [map.get(a), map.get(b)];
    });
    p = Array(index).fill(0).map((_, id) => id);
    size = Array(index).fill(1);

    const result = [];
    for (const [a, b] of friends) {
        union(a, b);
        result.push(size[find(a)]);
    }
    console.log(result.join("\n"));

    line += f;
}

function find(x) {
    if (p[x] === x) return x;
    return p[x] = find(p[x]);
}

function union(a, b) {
    a = find(a);
    b = find(b);
    if (a === b) return;
    if (size[a] < size[b]) {
        p[a] = b;
        size[b] += size[a];
    } else {
        p[b] = a;
        size[a] += size[b];
    }
}