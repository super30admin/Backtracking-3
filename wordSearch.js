// Time Complexity : O(M*N 3^L) //L is dirs array
// Space Complexity : O(N) recurssive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var exist = function(board, word) {
    let m, n;
    if(board == null || board.length == 0) return false;
    let dirs = [[0,1], [0,-1], [-1,0], [1,0]]; 

    m = board.length;
    n = board[0].length;

    for(let i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(backtrack(board, word, i, j, 0)){
                return true;
            }
        }
    }
    return false

    function backtrack(borad, word, i, j, index) {
        //base 
        
        if(index == word.length) return true;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '#') return false
    
        //logic
        
        if(word.charAt(index) == borad[i][j]){
            let temp = board[i][j];
            board[i][j] = '#';
            for(const dir of dirs){
                let r = i + dir[0];
                let c = j + dir[1];
                if(backtrack(board, word, r, c, index + 1)) return true;
            }
            board[i][j] = temp
        }
        return false
    }
};