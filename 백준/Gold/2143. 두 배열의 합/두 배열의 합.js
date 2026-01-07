const input = require("fs")
  .readFileSync(
    process.platform === "linux" ? "/dev/stdin" : "input.txt",
    "utf8",
  )
  .trim()
  .split("\n");

const t = +input[0];
const n = +input[1];
const a = input[2].split(" ").map(Number);
const m = +input[3];
const b = input[4].split(" ").map(Number);

const prefixA = [a[0]];
for (let i = 1; i < n; i++) {
  prefixA[i] = a[i] + prefixA[i - 1];
}

const prefixB = [b[0]];
for (let i = 1; i < m; i++) {
  prefixB[i] = b[i] + prefixB[i - 1];
}

const sum = (arr, l, r) => (l === 0 ? arr[r] : arr[r] - arr[l - 1]);

const subPrefixA = [];
for (let i = 0; i < n; i++) {
  for (let j = i; j < n; j++) {
    subPrefixA.push(sum(prefixA, i, j));
  }
}
subPrefixA.sort((a, b) => a - b);

const subPrefixB = [];
for (let i = 0; i < m; i++) {
  for (let j = i; j < m; j++) {
    subPrefixB.push(sum(prefixB, i, j));
  }
}

function lowerBound(arr, target) {
  let left = 0;
  let right = arr.length;

  while (left < right) {
    const mid = Math.floor((left + right) / 2);
    if (arr[mid] < target) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return left;
}

function upperBound(arr, target) {
  let left = 0;
  let right = arr.length;

  while (left < right) {
    const mid = Math.floor((left + right) / 2);
    if (arr[mid] <= target) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return left;
}

let count = 0;
for (const x of subPrefixB) {
  const target = t - x;
  count += upperBound(subPrefixA, target) - lowerBound(subPrefixA, target);
}

console.log(count);