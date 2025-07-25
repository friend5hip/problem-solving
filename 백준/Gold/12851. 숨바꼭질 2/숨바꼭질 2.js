const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf-8")
    .trim()
    .split("\n");

class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

const Queue = () => {
    const queue = [];
    let start = 0;
    let end = 0;

    const add = (e) => {
        queue.push(e);
        end++;
    }

    const poll = () => {
        return queue[start++];
    }

    return {
            add, 
            poll, 
            get length() {
                return end - start;
            }
    }
}

const [n, k] = input[0].split(" ").map(Number);

let count = 0;
let minTime = -1;

bfs(n);
console.log(minTime);
console.log(count);

function bfs(start) {
    const visited = Array(100000).fill(false);
    const q = Queue();
    q.add([start, 0]);

    while (q.length > 0) {
        const [current, currentTime] = q.poll();
        visited[current] = true;
        
        if (current === k) {
            if (minTime === -1) {
                minTime = currentTime;
                count = 1;
            } else if (currentTime === minTime) {
                count++;
            }
            continue;
        }

        if (minTime !== -1 && currentTime > minTime) break;

        const moves = [current - 1, current + 1, current * 2];
        for (const move of moves) {
            const next = move;

            if (next < 0 || next > 100000) continue;
            if (!visited[next]) {
                q.add([next, currentTime + 1]);
            }
        }
    }
}
