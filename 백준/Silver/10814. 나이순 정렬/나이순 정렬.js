const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

const n = +input[0];
const users = input.slice(1).map(line => line.split(" "));

users.sort((a, b) => a[0] - b[0]);

const answer = users.map(line => line.join(" ")).join("\n");
console.log(answer);