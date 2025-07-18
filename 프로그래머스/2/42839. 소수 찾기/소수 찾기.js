function solution(numbers) {
    numbers = numbers.split("").map(e => Number(e));
    const allNumbers = getCombs(numbers);
    console.log(allNumbers);
    let count = 0;
    for (const number of allNumbers) {
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

function getCombs(numbers) {
    const result = new Set();

    function dfs(path, used) {
            if (path.length > 0) {
        result.add(Number(path.join('')));
        }

        for (let i = 0; i < numbers.length; i++) {
        if (used[i]) continue;

        used[i] = true;
        path.push(numbers[i]);
        dfs(path, used);
        path.pop();
        used[i] = false;
        }
    }

    dfs([], Array(numbers.length).fill(false));

    return Array.from(result).sort((a, b) => a - b);
}