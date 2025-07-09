function solution(genres, plays) {
    const genreMap = new Map();
    const songMap = new Map();
    
    for (let i = 0; i < genres.length; i++) {
        const genre = genres[i];
        const play = plays[i];
        
        genreMap.set(genre, (genreMap.get(genre) || 0) + play);
       
        if (!songMap.has(genre)) songMap.set(genre, []);
        songMap.get(genre).push([i, play]);
    }
    
    const sortedGenres = [...genreMap.entries()].sort((a, b) => b[1] - a[1]);
    
    const result = [];
    for (const [genre] of sortedGenres) {
        const songs = songMap.get(genre);
        songs.sort((a, b) => {
            if (b[1] === a[1]) return a[0] - b[0];
            return b[1] - a[1];
        })
        result.push(...songs.slice(0, 2).map(song => song[0]));
    }
    
    return result;
}