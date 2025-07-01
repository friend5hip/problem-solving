function solution(record) {
    const userMap = {};
    const actions = [];

    for (const entry of record) {
        const [cmd, uid, nick] = entry.split(" ");
        if (cmd !== "Leave") userMap[uid] = nick;
    }

    for (const entry of record) {
        const [cmd, uid] = entry.split(" ");
        if (cmd === "Enter") actions.push(`${userMap[uid]}님이 들어왔습니다.`);
        else if (cmd === "Leave") actions.push(`${userMap[uid]}님이 나갔습니다.`);
    }

    return actions;
}
