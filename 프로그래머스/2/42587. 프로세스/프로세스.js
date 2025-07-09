function solution(priorities, location) {
    const queue = priorities.map((e, i) => ({ priority: e, idx: i }));
    let count = 0;
    while (queue.length) {
        const current = queue.shift();
        
        if (queue.some(task => task.priority > current.priority)) {
            queue.push(current);
        } else {
            count++;
            if (current.idx === location) {
                return count;
            }
        }
    }
}