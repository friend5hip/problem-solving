function solution(sizes) {
    let [maxW, maxH] = sizes[0];
    for (let i = 1; i < sizes.length; i++) {
        const [w, h] = sizes[i];
        if ((w < maxW && h < maxH) || (h < maxW && w < maxH)) continue;
        else {
            if (Math.max(w, maxW) * Math.max(h, maxH) < Math.max(h, maxW) * Math.max(w, maxH)) {
                maxW = Math.max(w, maxW);
                maxH = Math.max(h, maxH);
            } else {
                maxW = Math.max(h, maxW);
                maxH = Math.max(w, maxH);
            }
        }
    }
    
    return maxW * maxH;
}

// 제일 큰 가로, 세로로 만들면 모든 명함 수납 가능
// 하지만 명함을 회전 시켜봤을 때 더 작은 가로, 세로가 가능하다면 그 길이를 선택
// 하나씩 가능한 길이를 겹쳐보면서 최대 가로, 세로 길이를 갱신