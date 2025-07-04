const [n] = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n")
    .map(Number);

if (n === 1) {
    console.log(n);
    return;
}

let a = 2;
let b = 7;
let layer = 1;
while (true) {
    if (a <= n && n <= b) {
        console.log(layer + 1);
        break;
    } else {
        a += 6 * layer;
        b += 6 * (layer + 1);
        layer++;
    }
}