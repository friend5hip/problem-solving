function solution(fees, records) {
    // 차량번호를 기준으로 주차요금 계산
    // 주차요금 계산에 필요한 정보: 
    // 1. 몇분을 사용했는지? 
    // 2. 마지막 기록이 "IN"인지 "OUT"인지?
    const inMap = new Map();
    const totalTime = new Map();
    for (const record of records) {
        const [timeStr, carNum, state] = record.split(" ");
        const time = timeStrToMinute(timeStr);
        
        if (!inMap.has(carNum)) {
            inMap.set(carNum, time);
        } else {
            const inTime = inMap.get(carNum);
            const used = time - inTime;
            inMap.delete(carNum);
            
            totalTime.set(carNum, (totalTime.get(carNum) || 0) + used);
        }
    }
    
    const LAST_TIME = timeStrToMinute("23:59");
    for (const [carNum, inTime] of inMap.entries()) {
        const used = LAST_TIME - inTime;
        totalTime.set(carNum, (totalTime.get(carNum) || 0) + used);
    }
    
    const answer = Array.from(totalTime.entries())
        .sort((a, b) => a[0].localeCompare(b[0]))
        .map(([carNum, usedTime]) => calculateFee(fees, usedTime));
    
    return answer;
}

function timeStrToMinute(time) {
    const [h, m] = time.split(":").map(Number);
    return h * 60 + m;
}

function calculateFee([baseTime, baseFee, unitTime, unitFee], usedTime) {
    if (usedTime <= baseTime) {
        return baseFee;
    } else {
        return baseFee + Math.ceil((usedTime - baseTime) / unitTime) * unitFee; 
    }
}