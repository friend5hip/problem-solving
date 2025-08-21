function solution(name) {
    let vertCount = 0;
    let horCount = name.length - 1;
    let foundA = false;
    
    // 세로 조작 횟수 계산
    for (let i = 0; i < name.length; i++) {
        if (name[i] === 'A') foundA = true; 
        vertCount += getUpDownCost(name[i]);
    }
    
    // 가로 조작 횟수 계산
    if (foundA) {
        for (let i = 0; i < name.length; i++) {
            let nextIndex = i + 1;
            while (nextIndex < name.length && name[nextIndex] === 'A') {
                nextIndex++;
            }
            const right = i * 2 + (name.length - nextIndex);
            const left = i + 2 * (name.length - nextIndex);
            horCount = Math.min(horCount, left, right);
        }
    }

    return vertCount + horCount;
    
    function getUpDownCost(char) {
        const index = char.charCodeAt(0);
        return Math.min(index - 'A'.charCodeAt(0), 'Z'.charCodeAt(0) - index + 1);
    }
}

// 휴리스틱하게 생각해봤을 때, 빠른 방향을 선택해야 함
// 보통의 경우 첫 번째 위치에서 오른쪽으로 커서를 이동하며 조작
// Z를 만드려면 A에서 한 번만 이동하는 것으로 가능
// 알파벳을 절반으로 나눠서 13~25는 아래로, 0~12는 위로 조작
// 커서 이동 시 오른쪽으로 가는 것보다 왼쪽이 빠르면 왼쪽으로 조작
// 이름의 길이를 절반으로 나눠서 뒤의 절반은 왼쪽으로, 앞의 절반은 오른쪽으로 조작

// 세로 조작은 미리 계산해놓을 수 있겠다.
// 모든 문자에 대해 위, 아래 조작중 최소 횟수를 그리디하게 선택

// 가로 조작은 어떻게 하지?
// 모든 i에 대해 조작 횟수를 계산해야 한다? 왜 그래야만 하는거지?