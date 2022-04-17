// Time Complexity : O(3^n) where n is word length
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

let dir = [[0,-1],[1,0],[0,1],[-1, 0]]; // L U R D
let rows = 0;
let cols = 0;

var helper = function(board, word, i, j, charIndex) {
    //console.log(`helper ${i} ${j} ${charIndex}`);
    
    // base case 
    if (i === rows || i < 0 || j === cols || j < 0 || board[i][j] === '#') return false;
    
    if (board[i][j] === word[charIndex]) {
        //console.log(`dir ${i} ${j} ${board[i][j]} ${word[charIndex]}`);   
        if(charIndex + 1 === word.length) return true;
        let ch = board[i][j];
        board[i][j] = '#';
        // action
        for (let [r,c] of dir) {
            let row = r+i, col = c+j;
            if (helper(board, word, row, col, charIndex + 1)) return true;

        }
        // backtrack
        board[i][j] = ch;
    }
    return false;
}

/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    rows = board.length;
    cols = board[0].length;
    
    //console.log(rows, cols)
    for (let i = 0 ; i < rows; i++) {
        for (let j = 0 ; j < cols; j++) {
              if(helper(board, word, i, j, 0)) return true;
        }
    }
    return false;
}