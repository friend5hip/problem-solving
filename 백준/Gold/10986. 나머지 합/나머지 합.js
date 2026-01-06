const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'input.txt', 'utf-8')
    .trim()
    .split('\n');

const [n, m] = input[0].split(' ').map(Number);
const sequence = input[1].split(' ').map(Number);

const prefix = [sequence[0]];
for (let i = 1; i < n; i++) {
    prefix[i] = (sequence[i] + prefix[i - 1]) % m;
}

const mod = [0];
for (let i = 0; i < n; i++) {
    mod.push(prefix[i] % m);
}

const map = new Map();
for (let i = 0; i < mod.length; i++) {
    map.set(mod[i], map.get(mod[i]) + 1 || 1);
}

let count = 0;
for (const entry of map.values()) {
    count += entry * (entry - 1) / 2
}

console.log(count);