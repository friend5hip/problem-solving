function solution(nums) {
    const set = new Set([...nums]);
    return Math.min(Math.floor(nums.length / 2), set.size);
}