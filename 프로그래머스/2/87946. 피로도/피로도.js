function solution(k, dungeons) {
    const visited = Array(dungeons.length).fill(false);
    let max = 0;
    
    function dfs(k, count) {
        max = Math.max(max, count);

        for (let i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
    
    dfs(k, 0);
    return max;
}


// 던전을 모두 탐색한다.
// 다음 던전을 탐색할 수 없으면 지금까지 탐험한 던전 수를 반환하고 종료한다.
// 종료 조건과 다음 탐색 조건을 어떻게 설정하지?
// 종료 조건과 탐색 조건을 파라미터로 넘길까?

