function solution(n) {
   return Array.from({ length: n }, (_, i) => i + 1)
       .filter(i => n % i === 0)
       .reduce((sum, i) => sum += i, 0);
}