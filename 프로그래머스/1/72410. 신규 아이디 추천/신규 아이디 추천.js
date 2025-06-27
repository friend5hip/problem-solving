function solution(new_id) {
    var answer = new_id.toLowerCase()
        .replace(/[^a-z0-9._-]/g, '')
        .replace(/\.{2,}/g, '.')
        .replace(/^\.|\.$/g, '')
        .replace(/^$/, 'a')
        .replace(/^(.{15}).*$/, '$1')
        .replace(/\.$/, '')
    while (answer.length <= 2) {
        answer += answer[answer.length - 1];
    }
    return answer;
}