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

class Queue {
  constructor() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  add(value) {
    const newNode = new Node(value);
    if (!this.head) {
      this.head = newNode;
      this.tail = newNode;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    this.size++;
  }

  poll() {
    if (!this.head) return null;
    const removeNode = this.head;
    this.head = this.head.next;
    if (!this.head) {
      this.tail = null;
    }
    this.size--;
    return removeNode.value;
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
    const q = new Queue();
    q.add([start, 0]);

    while (q.size > 0) {
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
