function solution(bridge_length, weight, truck_weights) {
    const queue = [];
    let time = 0;
    let current = 0;
    while (truck_weights.length > 0 || queue.length > 0) {
        // 맨 앞 트럭이 건넜는지 체크
        if (queue.length > 0 && time - queue[0].entered >= bridge_length) {
            const crossed = queue.shift();
            current -= crossed.weight;
        }
        // 다음 트럭이 건널 수 있는지 확인
        const next = truck_weights[0];
        if (current + next <= weight) {
            truck_weights.shift();
            queue.push({ weight: next, entered: time });
            current += next;
        }
        time++;
    }
    
    return time;
}