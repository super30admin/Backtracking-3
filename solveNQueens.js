// Time Complexity : O(n!) where n is board length
// Space Complexity : O(n^2) where n is board length
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
let result;
let board;
let m;

var isSafe = function(r,c) {
    //up
    for(let i = 0; i < r; i++) {
        if(board[i][c]) return false;
    }
    //up right
    let i = r*1, j = c*1;
    
    while(i >= 0 && j < m) {
        if(board[i][j]) return false;
        i--;
        j++;
    }
    
    //up left
    i = r*1;
    j = c*1;
    while(i >= 0 && j >= 0) {
        if(board[i][j]) return false;
        i--;
        j--;
    }
    return true;
}

var backtrack = function(row) {
    // base case
    if (row === m) {
        // prepare result
        result.push(board.reduce((acc, each) => {
            let rowString = each.reduce((preVal,newVal) => {
                preVal = (newVal === false) ? preVal+"." : preVal+"Q";
                return preVal;
            },'')
            acc.push(rowString);
            return acc;
        } , []));
    }
    
    for(let j = 0; j < m; j++) {
        if(isSafe(row,j)) {
            //action
            board[row][j] = true;
             // recursion
            backtrack(row+1);
            //backtrack
            board[row][j] = false;
        }
    }
}


/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    result = [];
    board = [];
    const emptyArray = new Array(n).fill(false);
    for (let i = 0 ;i < n ; i++) {
        board.push([...emptyArray]);
    }
    m = n * 1;
    backtrack(0);
    return result;
};