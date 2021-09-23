// Time Complexity : O(N!)
// Space Complexity : O(NxN)
// Did this code successfully run on Leetcode : Yes

let result;
let board;
var solveNQueens = function (n) {
    result = [];
    board = new Array(n);
    for (let i = 0; i < board.length; i++) {
        board[i] = new Array(n).fill(false);
    }
    helper(0);
    return result;
};

var helper = function (row) {
    //base
    if (row === board.length) {
        let li = [];
        for (let i = 0; i < board.length; i++) {
            let str = "";
            for (let j = 0; j < board.length; j++) {
                if (board[i][j] === true) {
                    str += "Q";
                } else {
                    str += ".";
                }
            }
            li.push(str);
        }
        result.push(li);
        return;

    }

    //logic
    for (let j = 0; j < board.length; j++) {
        if (isSafe(row, j)) {
            //action
            board[row][j] = true;
            //recurse
            helper(row + 1);
            //bactrack
            board[row][j] = false;
        }

    }
}

var isSafe = function (r, c) {
    let i, j;
    //same column
    for (i = 0; i < r; i++) {
        if (board[i][c] === true) return false;
    }
    //diagonal upper left
    i = r, j = c;
    while (i >= 0 && j >= 0) {
        if (board[i][j] === true) return false;
        i--;
        j--;
    }
    //diagonal upper right
    i = r, j = c;
    while (i >= 0 && j < board.length) {
        if (board[i][j] === true) return false;
        i--;
        j++;
    }
    return true;

}