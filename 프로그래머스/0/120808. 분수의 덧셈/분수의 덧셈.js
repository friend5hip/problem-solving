function solution(numer1, denom1, numer2, denom2) {
    var answer = [];
    const a = lcm(denom1, denom2);
    numer1 *= (a / denom1);
    numer2 *= (a / denom2);
    const numer = numer1 + numer2;
    answer.push((numer1 + numer2) / gcd(numer, a));
    answer.push(a / gcd(numer, a));
    
    return answer;
}

function gcd(a, b) {
    while (b > 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

function lcm(a, b) {
    return (a * b) / gcd(a, b);
}