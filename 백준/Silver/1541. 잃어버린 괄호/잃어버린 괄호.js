const input = require("fs")
  .readFileSync(
    process.platform === "linux" ? "/dev/stdin" : "./input.txt",
    "utf8"
  )
  .trim();

const numbers = input.replaceAll("-", " ").split(" ");

let sum = 0;
for (let i = 0; i < numbers.length; i++) {
  if (i === 0) {
    numbers[i] = numbers[i]
    .split("+")
    .map(Number)
    .reduce((acc, num) => (acc += num), 0);
    sum += numbers[i];
    continue;
  }
  numbers[i] = numbers[i]
    .split("+")
    .map(Number)
    .reduce((acc, num) => (acc += num), 0);
  sum -= Number(numbers[i]);
}

console.log(sum);
