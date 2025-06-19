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

const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

function solution(maps) {
    const visited = Array.from({ length: maps.length }, () => Array(maps[0].length).fill(false));
    const answer = bfs(0, 0, maps, visited);
    return answer;
}

function bfs(x, y, maps, visited) {
    const q = new Queue();
    q.add([x, y, 1]);
    visited[x][y] = true;
    
    while (q.size > 0) {
        const [cx, cy, ct] = q.poll();
        
        if (cx === maps.length - 1 && cy === maps[0].length - 1) return ct;
        
        const moves = [
            [cx + dx[0], cy + dy[0]],
            [cx + dx[1], cy + dy[1]],
            [cx + dx[2], cy + dy[2]],
            [cx + dx[3], cy + dy[3]],
        ]
        for (const [nx, ny] of moves) {
            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
            if (!visited[nx][ny] && maps[nx][ny] === 1) {
                q.add([nx, ny, ct + 1]);
                visited[nx][ny] = true;
            } 
        }
    }
    
    return -1;
}