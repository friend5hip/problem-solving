function solution(distance, rocks, n) {
    rocks.push(distance);
    rocks.sort((a, b) => a - b);
    
    let left = 1;
    let right = distance;
    let answer = 0;
    while (left <= right) {
        const mid = Math.floor((left + right) / 2);
        let prev = 0;
        let removed = 0;
        for (const rock of rocks) {
            if (rock - prev < mid) {
                removed += 1;
            } else {
                prev = rock;
            }
        }
        
        if (removed > n) {
            right = mid - 1;
        } else {
            answer = mid;
            left = mid + 1;
        }
    }
    
    return answer;
}