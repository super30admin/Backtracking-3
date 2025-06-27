// ## Problem1 
// N Queens(https://leetcode.com/problems/n-queens/)


var solveNQueens = function(n) {
    //TC: N!
    //SC O(1)
    let res = []
    let board = Array.from({ length: n }, () => Array(n).fill('.'));
function isSafe(row, col) {
    // Check column (↑)
    for (let r = row - 1; r >= 0; r--) {
        if (board[r][col] === "Q") return false;
    }

    // Check top-left diagonal (↖)
    for (let r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
        if (board[r][c] === "Q") return false;
    }

    // Check top-right diagonal (↗)
    for (let r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
        if (board[r][c] === "Q") return false;
    }

    return true;
}

    function solve(row){

        if(row >= n){
            res.push(board.map((ele)=>ele.join('')))
            return
        }
        for(let col=0;col<n;col++){

            if(isSafe(row,col)){
            board[row][col] = "Q"
            solve(row+1)
            board[row][col] = "."
            }

        }
    }
    solve(0)
    return res
};

// var solveNQueens = function(n) {
    //TC: N!
    //SC O(1)
//     const output = [];
//     const nQueens = Array(n).fill().map(() => Array(n).fill('.'));
    
//     // Check if placing a queen at (row, col) is safe
//     function isSafePlace(row, col) {
//         let r = row, c = col;

//         // Check upper-left diagonal
//         while (r >= 0 && c >= 0) {
//             if (nQueens[r][c] === 'Q') return false;
//             r--; c--;
//         }

//         r = row; c = col;
//         // Check left (same row)
//         while (c >= 0) {
//             if (nQueens[r][c] === 'Q') return false;
//             c--;
//         }

//         r = row; c = col;
//         // Check lower-left diagonal
//         while (r < n && c >= 0) {
//             if (nQueens[r][c] === 'Q') return false;
//             r++; c--;
//         }

//         return true;
//     }

//     // Column-wise recursive solver
//     function solve(col) {
//         if (col === n) {
//             output.push(nQueens.map(row => row.join('')));
//             return;
//         }

//         for (let row = 0; row < n; row++) {
//             if (isSafePlace(row, col)) {
//                 nQueens[row][col] = 'Q';
//                 solve(col + 1);
//                 nQueens[row][col] = '.';
//             }
//         }
//     }

//     solve(0);
//     return output;
// };
