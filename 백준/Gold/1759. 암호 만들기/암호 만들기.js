const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt", "utf8")
  .trim()
  .split("\n")

const [l, c] = input[0].split(" ").map(Number);
const chars = input[1].split(" ").sort((a, b) => a.localeCompare(b));
const vowels = ['a', 'e', 'i', 'o', 'u'];
const result = [];

dfs([], 0);
console.log(result.join("\n"));

function dfs(current, index) {
    if (current.length === l) {
        let vowelCount = 0;
        let consonantCount = 0;

        for (const char of current) {
            if (vowels.includes(char)) vowelCount++;
            else consonantCount++;
        }

        if (vowelCount >= 1 && consonantCount >= 2) {
            result.push(current.join(""));   
        }
    }

    for (let i = index; i < c; i++) {
        current.push(chars[i]);
        dfs(current, i + 1);
        current.pop();
    }
}