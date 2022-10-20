// N Queens(https://leetcode.com/problems/n-queens/)

// TC: O(n!)
// SC: O(n^2)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

let result;
let nLength;
let grid;
var isValid = (row, col) => {
    // Check above cols
    let i = row - 1;
    while (i >= 0) {
        if (grid[i][col] === true)
            return false;
        i--;
    }
    // Check top left diagonals
    i = row - 1;
    let j = col - 1;
    while (i >= 0 && j >= 0) {
        if (grid[i][j] === true)
            return false;
        i--; j--;
    }
    // Check top right diagonals
    i = row - 1;
    j = col + 1;
    while (i >= 0 && col < nLength) {
        if (grid[i][j] === true)
            return false;
        i--; j++;
    }
    return true;
}
var backtrack = (row) => {
    // Base
    if (row === nLength) {
        let outerGrid = [];
        for (let i = 0; i < nLength; i++) {
            let innerGrid = "";
            for (let j = 0; j < nLength; j++) {
                if (grid[i][j]) {
                    innerGrid += 'Q';
                } else {
                    innerGrid += '.';
                }
            }
            outerGrid.push(innerGrid);
        }
        result.push(outerGrid)
        return;
    }
    // Logic
    for (let col = 0; col < nLength; col++) {
        if (isValid(row, col)) {
            // Action
            grid[row][col] = true;
            // Recurse
            backtrack(row + 1);
            // Backtrack
            grid[row][col] = false;
        }
    }
}
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
    if (n === 0)
        return [];
    nLength = n;
    result = [];
    grid = new Array(n);
    for (let i = 0; i < n; i++) {
        grid[i] = new Array(n);
        grid[i].fill(false);
    }
    // console.log(grid)
    backtrack(0);

    return result;
};