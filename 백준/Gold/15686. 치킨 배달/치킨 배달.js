const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const map = input.slice(1).map(e => e.split(" ").map(Number));
const chickens = [];
const houses = [];
const dx = [1, -1, 0, 0];
const dy = [0, 0, -1, 1];

for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
        if (map[i][j] === 2) {
            chickens.push([i, j]);
        } else if (map[i][j] === 1) {
            houses.push([i, j]);
        }
    }
}

let min = Infinity;
getMin([], 0);
console.log(min);

function getMin(current, index) {
    if (current.length === m) {
        // 최소 치킨 거리 구하고 갱신
        let count = 0;
        for (let i = 0; i < houses.length; i++) {
            const [r, c] = houses[i];
            count += getDist(r, c, current);
        }
        min = Math.min(min, count);
        return;
    }

    for (let i = index; i < chickens.length; i++) {
        const chicken = chickens[i];
        current.push(chicken);
        getMin(current, i + 1);
        current.pop();
    }
}

function getDist(r, c, targets) {
    let minDist = Infinity;
    for (let i = 0; i < targets.length; i++) {
        const [tr, tc] = targets[i];
        const dist = Math.abs(r - tr) + Math.abs(c - tc);
        minDist = Math.min(minDist, dist);
    }
    return minDist;
}