function solution(brown, yellow) {
    const total = brown + yellow;
    for (let b = Math.floor(brown / 2); b >= 1; b--) {
        for (let y = 1; y <= yellow; y++) {
            if (b - 2 !== y) continue;
            const bHeight = (brown - b * 2) / 2 + 2 > 0 ? (brown - b * 2) / 2 + 2 : 1;
            const yHeight = (yellow - y * 2) / 2 > 0 ? (yellow - y * 2) / 2 + 2 : 1;
            if ((b * bHeight) === total) {
                return [b, bHeight];
            }
        }
    }
}