const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

function solution(maps) {
    const visited = Array.from({ length: maps.length }, () => Array(maps[0].length).fill(false));
    const answer = bfs(0, 0, maps, visited);
    return answer;
}

function bfs(x, y, maps, visited) {
    const q = [[x, y, 1]];
    visited[x][y] = true;
    
    while (q.length > 0) {
        const [cx, cy, ct] = q.shift();
        
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
                q.push([nx, ny, ct + 1]);
                visited[nx][ny] = true;
            } 
        }
    }
    
    return -1;
}