// Time Complexity : O(N 3^L) L is length of the string
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes

let m, n;
let dirs;
var exist = function (board, word) {
    if (!board || board.length === 0) return false;

    m = board.length, n = board[0].length;
    dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (backtrack(board, word, i, j, 0)) {
                return true;
            }
        }
    }
    return false;

};

var backtrack = function (board, word, i, j, index) {
    //base
    if (i < 0 || j < 0 || i === m || j === n || board[i][j] === "#") return false;
    if (index === word.length) return true;

    //logic
    if (word.charAt(index) === board[i][j]) {
        if (index === word.length - 1) return true;
        //action
        let char = board[i][j];
        board[i][j] = "#";
        //recurse
        for (let dir of dirs) {
            let r = i + dir[0];
            let c = j + dir[1];
            if (backtrack(board, word, r, c, index + 1)) return true;

        }
        //backtrack
        board[i][j] = char;
    }

    return false;

}