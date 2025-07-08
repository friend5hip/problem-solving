function solution(clothes) {
    const map = new Map();
    for (let [name, category] of clothes) {
        map.set(category, (map.get(category) || 0) + 1);
    }
    let combs = 1;
    for (let [category, count] of map) {
        combs *= (count + 1);
    }
    return combs - 1;
}