const input = require("fs")
    .readFileSync(process.platform === "linux" ? "/dev/stdin" : "input.txt", "utf8")
    .trim()
    .split("\n");

let i = 0;
while (true) {
    const test = input[i].split(" ").map(Number);
    const [k, ...s] = test;
    
    if (k === 0) break;
    
    dfs([], 0, k, s);
    console.log();
    i++;
}

function dfs(current, index, k, s) {
    if (current.length === 6) {
        console.log(current.join(" "));
        return;
    }

    for (let i = index; i < k; i++) {
        current.push(s[i]);
        dfs(current, i + 1, k, s);
        current.pop();
    }
}