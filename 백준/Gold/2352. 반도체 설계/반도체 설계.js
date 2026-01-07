const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt', 'utf-8')
    .trim()
    .split('\n');

const n = +input[0];
const ports = input[1].split(' ').map(Number);

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
for (const port of ports) {
    const pos = lowerBound(lis, port);
    if (pos === lis.length) {
        lis.push(port);
    } else {
        lis[pos] = port;
    }
}

console.log(lis.length);