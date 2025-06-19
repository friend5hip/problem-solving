function solution(tickets) {
    const answer = [];
    const visited = Array(tickets.length).fill(false);

    tickets.sort((a, b) => {
        if (a[0] === b[0]) {
            return a[1].localeCompare(b[1]);
        } else {
            return a[0].localeCompare(b[0]);
        }
    });

    function dfs(path, count) {
        if (count === tickets.length) {
            answer.push([...path]);
            return;
        }

        for (let i = 0; i < tickets.length; i++) {
            const [from, to] = tickets[i];
            if (!visited[i] && path[path.length - 1] === from) {
                visited[i] = true;
                path.push(to);
                dfs(path, count + 1);
                path.pop();
                visited[i] = false;
            }
        }
    }

    dfs(["ICN"], 0);

    // 사전순으로 가장 빠른 경로를 선택
    answer.sort();
    return answer[0];
}
