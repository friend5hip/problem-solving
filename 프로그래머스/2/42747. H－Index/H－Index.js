function solution(citations) {
    const sorted = citations.sort((a, b) => b - a);
    for (let i = 0; i < sorted.length; i++) {
        if (sorted[i] <= i) {
            return i;
        }
    }
    return sorted.length;
}