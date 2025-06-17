function solution(array) {
    var answer = 0;
    const map = new Map();
    const freq = array.reduce((map, num) => {
        map.set(num, (map.get(num) || 0) + 1);
        return map;
    }, new Map());
    
    const sorted = [...freq.entries()].sort((a, b) => b[1] - a[1]);
    return sorted.length > 1 && sorted[0][1] === sorted[1][1] ? -1 : sorted[0][0];
}