const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split("\n");

const n = +input[0];
const sequence = input[1].split(' ').map(Number);

const lowerBound = (arr, target) => {
    let left = 0;
    let right = arr.length;
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}

const lis = [];
const parent = [];
for (let i = 0; i < n; i++) {
    const num = sequence[i];
    const pos = lowerBound(lis, num);
    if (pos === lis.length) {
        lis.push(num);
        parent[i] = lis.length - 1;
    } else {
        lis[pos] = num;
        parent[i] = pos;
    }
}

const result = [];
let currentLength = lis.length - 1
for (let i = n - 1; i >= 0; i--) {
    if (parent[i] === currentLength) {
        result.push(sequence[i]);
        currentLength--;
    }
}

console.log(lis.length);
console.log(...result.reverse());