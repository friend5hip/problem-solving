function solution(nums) {
    const map = new Map();
    for (const num of nums) {
        map.set(num, (map.get(num) || 0) + 1);
    }
    return Math.min(Math.floor(nums.length / 2), map.size);
}