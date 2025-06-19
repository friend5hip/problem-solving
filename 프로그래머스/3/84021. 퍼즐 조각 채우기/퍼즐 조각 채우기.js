const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

function solution(game_board, table) {
    const LENGTH = game_board.length;

    function bfs(sx, sy, board, value, visited) {
        const q = [[sx, sy]];
        const result = [[sx, sy]];
        visited[sx][sy] = true;

        while (q.length > 0) {
            const [x, y] = q.shift();

            for (let i = 0; i < 4; i++) {
                const nx = x + dx[i];
                const ny = y + dy[i];

                if (nx < 0 || nx >= LENGTH || ny < 0 || ny >= LENGTH) continue;
                if (!visited[nx][ny] && board[nx][ny] === value) {
                    visited[nx][ny] = true;
                    q.push([nx, ny]);
                    result.push([nx, ny]);
                }
            }
        }

        return getAbsoluteCoords(result);
    }

    function getAbsoluteCoords(piece) {
        const minX = Math.min(...piece.map(([x, y]) => x));
        const minY = Math.min(...piece.map(([x, y]) => y));
        return piece.map(([x, y]) => [x - minX, y - minY])
                    .sort((a, b) => a[0] - b[0] || a[1] - b[1]);
    }

    function rotate(piece) {
        return piece.map(([x, y]) => [y, -x]);
    }

    function getAllRotations(piece) {
        const rotations = [];
        let current = piece;
        for (let i = 0; i < 4; i++) {
            current = i === 0 ? piece : rotate(current);
            rotations.push(getAbsoluteCoords(current));
        }
        return rotations;
    }

    function isSame(a, b) {
        if (a.length !== b.length) return false;
        for (let i = 0; i < a.length; i++) {
            if (a[i][0] !== b[i][0] || a[i][1] !== b[i][1]) return false;
        }
        return true;
    }

    // 1. table에서 퍼즐 조각들 추출
    const visitedTable = Array.from({ length: LENGTH }, () => Array(LENGTH).fill(false));
    const pieces = [];
    for (let i = 0; i < LENGTH; i++) {
        for (let j = 0; j < LENGTH; j++) {
            if (!visitedTable[i][j] && table[i][j] === 1) {
                const piece = bfs(i, j, table, 1, visitedTable);
                pieces.push(getAllRotations(piece)); // 회전된 모든 형태 저장
            }
        }
    }

    // 2. game_board에서 빈 공간 추출하고 퍼즐 매칭
    const visitedBoard = Array.from({ length: LENGTH }, () => Array(LENGTH).fill(false));
    let answer = 0;
    const used = Array(pieces.length).fill(false);
    for (let i = 0; i < LENGTH; i++) {
        for (let j = 0; j < LENGTH; j++) {
            if (!visitedBoard[i][j] && game_board[i][j] === 0) {
                const hole = bfs(i, j, game_board, 0, visitedBoard);

                // 조각과 비교
                for (let piece = 0; piece < pieces.length; piece++) {
                    if (used[piece]) continue;

                    for (let r = 0; r < 4; r++) {
                        if (isSame(pieces[piece][r], hole)) {
                            used[piece] = true;
                            answer += hole.length;
                            break;
                        }
                    }

                    if (used[piece]) break;
                }
            }
        }
    }

    return answer;
}
