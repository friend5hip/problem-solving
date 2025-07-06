function solution(numbers) {
    numbers = numbers.map(String);
    numbers.sort((a, b) => (b + a) - (a + b));

    return numbers.join("")[0] === "0" ? "0" : numbers.join("");
}