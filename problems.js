// ## Problem2
// Word Search(https://leetcode.com/problems/word-search/)

let dirs = [[0,1], [1,0], [-1, 0], [0,-1]];
let m; 
let n;
let visited;
var exist = function(board, word) {
    m = board.length;
    n = board[0].length;
    visited = [];
    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(dfs(board,word, i, j)) return true;
        }
    }
    return false;
};

function dfs(board,word, i, j){
    // base cases
    if(i < 0 || i >= m ||j < 0 || j >= n || visited[i][j]) return false;
    // logic
    if(word[0] === board[i][j]){
        if(word.length == 1) return true;
        visited[i][j] = true;
        for(let dir of dirs){
            let r = i + dir[0];
            let c = j + dir[1];
            if(dfs(board,word.slice(1), r , c)) return true;
        }
        // backtrack
        visited[i][j] = false;
    } 
    return false;
}