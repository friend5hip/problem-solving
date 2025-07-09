function solution(bridge_length, weight, truck_weights) {
    const queue = [];
    let time = 0;
    let current = 0;
    while (truck_weights.length > 0 || queue.length > 0) {
        // 트럭 전진
        for (let truck of queue) {
            truck[1]++;
        }
        // 맨 앞 트럭이 건넜는지 체크
        if (queue.length > 0 && queue[0][1] >= bridge_length) {
            const crossed = queue.shift();
            current -= crossed[0];
        }
        // 다음 트럭이 건널 수 있는지 확인
        const next = truck_weights[0];
        if (current + next <= weight) {
            queue.push([truck_weights.shift(), 0]);
            current += next;
        }
        time++;
    }
    
    return time;
}