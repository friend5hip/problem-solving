function solution(record) {
    const userList = {};
    for (const log of record) {
        const [command, uid, nickname] = log.split(" ");
        if (command === "Enter" && userList[uid] || command === "Change") {
            userList[uid] = nickname;
        } else {
            if (!userList[uid]) {
                userList[uid] = nickname;
            }
        }
    }
    
    const logs = [];
    for (const log of record) {
        const [command, uid, nickname] = log.split(" ");
        switch (command) {
            case "Enter": logs.push(`${userList[uid]}님이 들어왔습니다.`); break;
            case "Leave": logs.push(`${userList[uid]}님이 나갔습니다.`); break;
        }
    }
    
    return logs;
}