const input = require("fs")
  .readFileSync(process.platform === "linux" ? 0 : "./input.txt", "utf8")
  .trim()
  .split("\n");

const [n, m] = input[0].split(" ").map(Number);
const [knowing, ...knowings] = input[1].split(" ").map(Number);
const parties = input.slice(2, 2 + m).map(e => e.split(" ").map(Number));

const p = Array(n + 1).fill(0).map((_, i) => i);

for (const party of parties) {
    const [number, ...participants] = party;
    if (number < 1) continue;
    for (let i = 1; i < participants.length; i++) {
        const a = participants[i - 1];
        const b = participants[i];
        union(a, b);
    }
}

let count = 0;
for (const party of parties) {
    const [number, ...participants] = party;
    let caught = false;
    outer:
    for (const knowing of knowings) {
        let root = find(knowing);
        for (const participant of participants) {
            if (find(participant) === root) {
                caught = true;
                break outer;
            }
        }
    }
    if (caught) continue;
    else count++;
}

console.log(count);

function find(x) {
    if (p[x] === x) return x;
    return p[x] = find(p[x]);
}

function union(a, b) {
    a = find(a);
    b = find(b);
    if (a === b) return;
    if (a < b) p[b] = a;
    else p[a] = b;
}