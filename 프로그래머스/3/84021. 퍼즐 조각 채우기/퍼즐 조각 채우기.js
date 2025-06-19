const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

function solution(game_board, table) {
    const LENGTH = game_board.length;

    function bfs(sx, sy, board, value, visited) {
        const q = [[sx, sy]];
        visited[sx][sy] = true;
        
        const result = [[sx, sy]];
        while (q.length > 0) {
            const [cx, cy] = q.shift();
            
            for (let i = 0; i < 4; i++) {
                const nx = cx + dx[i];
                const ny = cy + dy[i];
                
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
        const minX = Math.min(...piece.map(([x, y]) => x)); // 개별 인자로 넘기기 위해 펼쳐서 전달
        const minY = Math.min(...piece.map(([x, y]) => y));
        return piece.map(([x, y]) => [x - minX, y - minY])
                    .sort((a, b) => a[0] - b[0] || a[1] - b[1]);
    }

    function rotate90(piece) {
        return piece.map(([x, y]) => [y, -x]);
    }

    function getAllRotations(piece) {
        const rotations = [piece];
        let current = piece;
        for (let i = 0; i < 3; i++) {
            current = rotate90(current);
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

    // table에서 퍼즐 조각들을 추출한다.
    const pieces = []; // 모든 조각의 형태를 담는다.
    const visitedTable = Array.from({ length: LENGTH }, () => Array(LENGTH).fill(false));
    for (let i = 0; i < LENGTH; i++) {
        for (let j = 0; j < LENGTH; j++) {
            if (!visitedTable[i][j] && table[i][j] === 1) {
                const piece = bfs(i, j, table, 1, visitedTable);
                pieces.push(getAllRotations(piece));
            }
        }
    }
    
    // game_board에서 빈 공간 추출해 조각이 들어갈 수 있는지 체크한다.
    let answer = 0;
    const visitedBoard = Array.from({ length: LENGTH }, () => Array(LENGTH).fill(false));
    const usedPieces = Array(pieces.length).fill(false);
    for (let i = 0; i < LENGTH; i++) {
        for (let j = 0; j < LENGTH; j++) {
            if (!visitedBoard[i][j] && game_board[i][j] === 0) {
                const hole = bfs(i, j, game_board, 0, visitedBoard);
                
                // 빈 칸을 조각과 비교한다.
                for (let p = 0; p < pieces.length; p++) {
                    if (usedPieces[p]) continue;
                    // 회전시키며 들어가는지 체크한다.
                    for (let r = 0; r < 4; r++) {
                        if (isSame(pieces[p][r], hole)) {
                            usedPieces[p] = true;
                            answer += hole.length;
                            break;
                        }
                    }
                    
                    if (usedPieces[p]) break;
                }
            }
        }
    }
    
    return answer;
}
