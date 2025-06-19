const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
    .toString()
    .trim()
    .split('\n')
    .map(Number);

const stack = [];
const numbers = input.slice(1);

for (const num of numbers) {
    if (num === 0) {
        stack.pop();
    } else {
        stack.push(num);
    }
}

const sum = stack.reduce((acc, num) => acc += num, 0);
console.log(sum);