function solution(sizes) {
    let maxW = 0;
    let maxH = 0;
    
    for (const [w, h] of sizes) {
        const [longer, shorter] = w > h ? [w, h] : [h, w];
        maxW = Math.max(maxW, longer);
        maxH = Math.max(maxH, shorter);
    }
    
    return maxW * maxH;
}