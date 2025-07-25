const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf-8")
    .trim()
    .split("\n");

const Queue = () => {
    const queue = [];
    let start = 0;
    let end = 0;

    return {
        add: (e) => {
            queue.push(e);
            end++;
        },
        poll: () => {
            return queue[start++];
        },
        get length() {
            return end - start;
        }
    }
}

const [n, k] = input[0].split(" ").map(Number);

let count = 0;
let min = -1;

bfs(n);

console.log(min + "\n" + count);

function bfs(start) {
    const visited = Array(100001).fill(-1);
    const q = Queue();
    q.add([start, 0]);
    visited[start] = 0;

    while (q.length > 0) {
        const [current, time] = q.poll();
        
        if (current === k) {
            if (min === -1) {
                min = time;
                count = 1;
            } else if (time === min) {
                count++;
            }
            continue;
        }

        if (min !== -1 && time > min) break;

        for (const next of [current - 1, current + 1, current * 2]) {
            if (next < 0 || next > 100000) continue;
            if (visited[next] === -1 || visited[next] === time + 1) {
                q.add([next, time + 1]);
                visited[next] = time + 1;
            }
        }
    }
}
