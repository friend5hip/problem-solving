function solution(genres, plays) {
    const genreMap = new Map();
    const songMap = new Map();
    
    for (let i = 0; i < genres.length; i++) {
        genreMap.set(genres[i], (genreMap.get(genres[i]) || 0) + plays[i]);
        
        if (!songMap.has(genres[i])) {
            songMap.set(genres[i], [[i, plays[i]]]);
        } else {
            songMap.get(genres[i]).push([i, plays[i]]);
        }
    }
    
    const sortedGenres = [...genreMap].sort((a, b) => b[1] - a[1]);
    
    const album = [];
    for (const [genre] of sortedGenres) {
        const songs = [...songMap.get(genre)].sort((a, b) => {
            if (a[1] === b[1]) return a[0] - b[0];
            return b[1] - a[1];
        })
        album.push(songs.slice(0, 2).map(e => e[0]));
    }
    
    return album.flat();
}