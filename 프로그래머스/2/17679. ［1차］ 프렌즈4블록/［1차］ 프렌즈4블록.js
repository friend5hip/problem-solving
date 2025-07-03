function solution(m, n, board) {
    const map = board.map(line => line.split(""));
    let removedBlocks = 0;
    
    while (true) {
        // 맵을 순회하면서 2x2를 체크한다.
        const toBeRemoved = check2x2(map, m, n);
        if (toBeRemoved.length === 0) break;
        // 체크된 칸들을 0으로 변환한다.
        const blocks = replace(map, toBeRemoved);
        removedBlocks += blocks;
        // 블록을 아래로 떨어뜨린다.
        applyGravity(map);
    }

    return removedBlocks;
}

function check2x2(map) {
    const arr = [];
    for (let i = 0; i < map.length - 1; i++) {
        for (let j = 0; j < map[0].length - 1; j++) {
            if (map[i][j] === 0) continue;
            if (map[i][j] === map[i][j + 1] 
                && map[i][j + 1] === map[i + 1][j]
                && map[i + 1][j] === map[i + 1][j + 1]) {
                arr.push([i, j]); arr.push([i, j + 1]);
                arr.push([i + 1, j]); arr.push([i + 1, j + 1]);
            }
        }
    }
    
    return Array.from(new Set((arr.map(e => JSON.stringify(e))))).map(str => JSON.parse(str));
}

function replace(map, positions) {
    let blocks = 0;
    for (const [x, y] of positions) {
        map[x][y] = 0;
        blocks++;
    }
    return blocks;
}

function applyGravity(map) {
    const rows = map.length;
    const cols = map[0].length;

    for (let col = 0; col < cols; col++) {
        for (let row = rows - 1; row > 0; row--) {
            if (map[row][col] === 0) {
                // 위쪽에서 0이 아닌 값을 찾는다
                for (let k = row - 1; k >= 0; k--) {
                    if (map[k][col] !== 0) {
                        map[row][col] = map[k][col];
                        map[k][col] = 0;
                        break;
                    }
                }
            }
        }
    }
}
