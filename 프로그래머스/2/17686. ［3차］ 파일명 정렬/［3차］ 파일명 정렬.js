function solution(files) {
    // 파일명을 HEAD, NUMBER, TAIL로 분리
    // 주어진 조건에 따라 파일명을 정렬
    const tokens = [];
    for (const file of files) {
        const HEAD = file.split(/\d+/)[0];
        const NUMBER = file.match(/\d+/)[0];
        const TAIL = file.substring((HEAD + NUMBER).length);
        tokens.push([HEAD, NUMBER, TAIL]);
    }
    
    tokens.sort((a, b) => {
        if (a[0].toLowerCase() !== b[0].toLowerCase()) return a[0].localeCompare(b[0]);
        else if (Number(a[1]) !== Number(b[1])) return Number(a[1]) - Number(b[1]);
    })
    
    return tokens.map(token => token.join(""));
}