const [first, ...rows] = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt")
    .toString()
    .trim()
    .split("\n")

const [n, k] = first.split(" ").map(Number);
const grid = rows.map(line => [...line.trim()].map(Number));

class Queue {
    constructor() {
        this.items = {};
        this.head = 0;
        this.tail = 0;
    }

    isEmpty() {
        return this.head === this.tail;
    }

    add(x) {
        this.items[this.tail++] = x;
    }

    poll() {
        if (this.isEmpty()) {
            return undefined;
        }

        const item = this.items[this.head];
        delete this.items[this.head++];
        return item;
    }   
}

let visited = Array.from({ length: 2 }, () => new Array(n).fill(false));
console.log(bfs(0, 0));

function bfs(startX, startY) {
    const queue = new Queue();
    queue.add([startX, startY, 0]);
    visited[startX][startY] = true;

    while (!queue.isEmpty()) {
        const curr = queue.poll();
        const cx = curr[0];
        const cy = curr[1];
        const ct = curr[2];
        
        const moves = [
            [cx, cy + 1],
            [cx, cy - 1],
            [1 - cx, cy + k]
        ]
        for (const [nx, ny] of moves) {
            const nt = ct + 1;

            if (ny < nt) continue;
            if (ny >= n) return 1;
            if (nx < 0 || nx >= 2 || ny < 0 || ny >= n) continue;
            if (!visited[nx][ny] && grid[nx][ny] === 1) {
                queue.add([nx, ny, nt]);
                visited[nx][ny] = true;
            }
        }
    }

    return 0;
}