function solution(numbers) {
    numbers = numbers.split("").map(Number);
    const result = new Set();
    const used = Array(numbers.length).fill(false);

    function dfs(path) {
        if (path.length > 0) {
            result.add(Number(path.join("")));
        }

        for (let i = 0; i < numbers.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.push(numbers[i]);
            dfs(path);
            path.pop();
            used[i] = false;
        }
    }

    dfs([]);

    let count = 0;
    for (const number of result) {
        if (isPrime(number)) count++;
    }

    return count;
}

function isPrime(number) {
    if (number < 2) return false;
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) return false;
    }
    return true;
}
