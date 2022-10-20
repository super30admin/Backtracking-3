// Word Search(https://leetcode.com/problems/word-search/)

// TC: O(mn3^L)
// SC: O(L)
// m is rows, n is cols, L is word length

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
let dirs;
let m;
let n;

let dfs = (board, word, row, col, index) => {
    // Base
    if (index >= word.length) {
        return true;
    }
    if (row < 0 || row === m || col < 0 || col === n || board[row][col] !== word[index])
        return false;

    // Logic
    board[row][col] = ".";
    for (let i = 0; i < dirs.length; i++) {
        let dir = dirs[i];
        if (dfs(board, word, row + dir[0], col + dir[1], index + 1)) {
            return true;
        }
    }
    board[row][col] = word[index];
    return false;
}
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
    if (board === null || word === null || board.length === 0 || word.length === 0)
        return false;

    dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];
    m = board.length;
    n = board[0].length;

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (dfs(board, word, i, j, 0)) {
                return true;
            }
        }
    }
    return false;
};