const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf-8")
    .trim()
    .split('\n')

let n = +input[0];

let bags = 0;
while (n >= 0) {
    if (n % 5 === 0) {
        bags += n / 5;
        break;
    } else {
        bags++;
        n -= 3;
    }
}

console.log(n < 0 ? -1 : bags);