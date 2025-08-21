function solution(name) {
    const n = name.length;
    let foundA = false;
    let vertCount = 0;
    let horiCount = n - 1;
    
    for (let i = 0; i < n; i++) {
        const index = name[i].charCodeAt(0) - 65;
        if (index === 0) {
            foundA = true;
            continue;
        }
        vertCount += Math.min(index, 26 - index);
    }
    
    if (foundA) {
        for (let i = 0; i < n; i++) {
            let nextIndex = i + 1;
            while (nextIndex < n && name[nextIndex] === 'A') {
                nextIndex++;
            }
            const left = i + 2 * (n - nextIndex);
            const right = i * 2 + (n - nextIndex);
            horiCount = Math.min(horiCount, left, right);
        }
    }
    
    return vertCount + horiCount;
}