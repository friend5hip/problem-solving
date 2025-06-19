const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];

function solution(rectangle, characterX, characterY, itemX, itemY) {
    const map = Array.from({ length: 102 }, () => Array(102).fill(0));
    rectangle = rectangle.map(([x1, y1, x2, y2]) => [x1 * 2, y1 * 2, x2 * 2, y2 * 2]);
    characterX *= 2;
    characterY *= 2;
    itemX *= 2;
    itemY *= 2;

    for (const [x1, y1, x2, y2] of rectangle) {
        for (let x = x1; x <= x2; x++) {
            map[y1][x] = 1;
            map[y2][x] = 1;
        }
        for (let y = y1; y <= y2; y++) {
            map[y][x1] = 1;
            map[y][x2] = 1;
        }
    }
    
    for (const [x1, y1, x2, y2] of rectangle) {
        for (let x = x1 + 1; x < x2; x++) {
            for (let y = y1 + 1; y < y2; y++) {
                map[y][x] = 0;
            }
        }
    }
    
    function bfs() {
        const visited = Array.from({ length: 102 }, () => Array(102).fill(false));
        const queue = [[characterY, characterX, 0]];
        visited[characterY][characterX] = true;
    
        while (queue.length > 0) {
            const [cy, cx, dist] = queue.shift();
            if (cx === itemX && cy === itemY) return dist / 2;

            for (let i = 0; i < 4; i++) {
                const ny = cy + dx[i];
                const nx = cx + dy[i];

                if (!visited[ny][nx] && map[ny][nx] === 1) {
                    visited[ny][nx] = true;
                    queue.push([ny, nx, dist + 1]);
                }
            }
        }
    }
    
    return bfs();
}

