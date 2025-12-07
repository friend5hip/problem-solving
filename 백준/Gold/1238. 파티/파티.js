const fs = require("fs");
const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf-8")
    .trim()
    .split("\n");

const [N, M, X] = input[0].split(" ").map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
const reverseGraph = Array.from({ length: N + 1 }, () => []);

for (let i = 1; i <= M; i++) {
  const [u, v, w] = input[i].split(" ").map(Number);
  graph[u].push([v, w]);
  reverseGraph[v].push([u, w]);
}

class MinHeap {
  constructor() {
    this.h = [];
  }
  push(x) {
    this.h.push(x);
    let i = this.h.length - 1;
    while (i > 0) {
      let p = (i - 1) >> 1;
      if (this.h[p][0] <= this.h[i][0]) break;
      [this.h[p], this.h[i]] = [this.h[i], this.h[p]];
      i = p;
    }
  }
  pop() {
    if (this.h.length === 0) return undefined;
    if (this.h.length === 1) return this.h.pop();

    const top = this.h[0];
    this.h[0] = this.h.pop();

    let i = 0;
    const n = this.h.length;

    while (true) {
      let l = i * 2 + 1;
      let r = i * 2 + 2;
      let s = i;

      if (l < n && this.h[l][0] < this.h[s][0]) s = l;
      if (r < n && this.h[r][0] < this.h[s][0]) s = r;
      if (s === i) break;

      [this.h[i], this.h[s]] = [this.h[s], this.h[i]];
      i = s;
    }
    return top;
  }
  get size() {
    return this.h.length;
  }
}

function dijkstra(start, graph) {
  const dist = Array(N + 1).fill(Infinity);
  const visited = Array(N + 1).fill(false);
  const pq = new MinHeap();

  dist[start] = 0;
  pq.push([0, start]);

  while (pq.size) {
    const [d, node] = pq.pop();
    if (visited[node]) continue;
    visited[node] = true;

    for (const [next, w] of graph[node]) {
      if (dist[next] > d + w) {
        dist[next] = d + w;
        pq.push([dist[next], next]);
      }
    }
  }
  return dist;
}

const toX = dijkstra(X, reverseGraph);
const fromX = dijkstra(X, graph);

let answer = 0;

for (let i = 1; i <= N; i++) {
  const total = toX[i] + fromX[i];
  if (total > answer) answer = total;
}

console.log(answer);