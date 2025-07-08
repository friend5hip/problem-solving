function solution(participant, completion) {
    const map = new Map();
    for (const player of participant) {
        map.set(player, (map.get(player) || 0) + 1);
    }
    for (const player of completion) {
        map.set(player, map.get(player) - 1);
    }
    for (const [name, count] of map) {
        if (count > 0) return name;
    }
}