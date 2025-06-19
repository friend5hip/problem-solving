function solution(tickets) {
    const visited = Array(tickets.length).fill(false);
    let answer = [];

    tickets.sort((a, b) => {
        if (a[0] === b[0]) return a[1].localeCompare(b[1]);
        return a[0].localeCompare(b[0]);
    });
    
    console.log(tickets);

    function dfs(current, path) {
        if (path.length === tickets.length + 1) {
            answer = path;
            return true;
        }

        for (let i = 0; i < tickets.length; i++) {
            const [from, to] = tickets[i];
            if (!visited[i] && from === current) {
                visited[i] = true;
                if (dfs(to, [...path, to])) return true;
                visited[i] = false;
            }
        }

        return false;
    }

    dfs("ICN", ["ICN"]);
    return answer;
}
