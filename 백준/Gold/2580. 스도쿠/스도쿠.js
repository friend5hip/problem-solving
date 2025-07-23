const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const board = input.slice(0).map(e => e.split(" ").map(Number));

const empty = [];
for (let i = 0; i < 9; i++) {
    for (let j = 0; j < 9; j++) {
        if (board[i][j] === 0) {
            empty.push([i, j]);
        }
    }
}

function dfs(depth, index) {
    if (depth === empty.length) {
        let result = "";
        for (let i = 0; i < 9; i++) {
            result += board[i].join(" ") + "\n";
        }
        console.log(result.trim());
        process.exit(0);
    }

    for (let i = 1; i <= 9; i++) {
        const row = empty[index][0];
        const col = empty[index][1];
        if (isValid(row, col, i)) {
            board[row][col] = i;
            dfs(depth + 1, index + 1);
            board[row][col] = 0;
        }
    }
}

function isValid(row, col, number) {
    for (let i = 0; i < 9; i++) {
        // 행 체크
        if (board[row][i] === number) return false;
        // 열 체크
        if (board[i][col] === number) return false;
    }
    // 정사각형 체크
    for (let i = Math.floor(row / 3) * 3; i < Math.floor(row / 3) * 3 + 3; i++) {
        for (let j = Math.floor(col / 3) * 3; j < Math.floor(col / 3) * 3 + 3; j++) {
            if (board[i][j] === number) return false;
        }
    }
    return true;
}

dfs(0, 0);