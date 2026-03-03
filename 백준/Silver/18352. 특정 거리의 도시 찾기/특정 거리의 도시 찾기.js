class MinHeap {
    constructor() {
        this.h = [];
    }
    key(x) {
        return this.h[x][0];
    }
    push(x) {
        this.h.push(x);
        
        let i = this.h.length - 1;
        while (i > 0) {
            const p = (i - 1) >> i;
            if (this.key(p) <= this.key(i)) break;
            [this.h[p], this.h[i]] = [this.h[i], this.h[p]];
            i = p;
        }
    }
    pop() {
        const n = this.h.length;
        if (n === 0) return undefined;
        if (n === 1) return this.h.pop();

        const top = this.h[0];
        this.h[0] = this.h.pop();

        let i = 0;
        while (true) {
            let left = i * 2;
            let right = left + 1;
            let s = i;
            if (left < this.h.length && this.key(left) < this.key(s)) s = left;
            if (right < this.h.length && this.key(right) < this.key(s)) s = right;
            if (i === s) break;
            [this.h[s], this.h[i]] = [this.h[i], this.h[s]];
            i = s;
        }
        return top;
    }
    get size() {
        return this.h.length;
    }
}

function dijkstra(graph, start) {
    const dists = Array(n + 1).fill(Infinity);
    const pq = new MinHeap();

    dists[start] = 0;
    pq.push([0, start]);

    while (pq.size) {
        const [dist, node] = pq.pop();

        if (dists[node] < dist) continue;

        for (const [next, w] of graph[node]) {
            const nd = dist + w;
            if (nd < dists[next]) {
                dists[next] = nd;
                pq.push([nd, next]);
            }
        }
    }
    return dists;
}

const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf-8")
    .trim()
    .split("\n");

const [n, m, k, x] = input[0].split(" ").map(Number);
const graph = Array.from({ length: n + 1 }, () => []);
for (let i = 1; i <= m; i++) {
    const [from, to] = input[i].split(" ").map(Number);
    graph[from].push([to, 1]);
}

const minDists = dijkstra(graph, x);
const answer = minDists.reduce((acc, v, i) => {
    if (v === k) acc.push(i);
    return acc;
}, []);
answer.sort((a, b) => a - b);
console.log(answer.length > 0 ? answer.join("\n") : -1);