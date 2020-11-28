// Time Complexity : O(N!) 
// Space Complexity : O(N^2) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let res = [];
    let board = Array(n).fill(0).map(_ => Array(n).fill(0));
    
    let m = n;
    backtrack(0);
    return res;

    function backtrack(r){
        //base
        let temp2 = []
        if(r ==m){
            
            //put string corresponding to each row of board
            
            for(let i = 0; i < m; i++){
                let temp = [];
                for(let j = 0; j < m; j++){
                    if(board[i][j] == 0){
                        temp.push(".")
                    }
                    else {
                        temp.push("Q")
                    }  
                }
                temp2.push(temp.join(""))
            }
            
            res.push(temp2)
            return;
        }
        //logic
        for(let j = 0; j < m; j++){
            if(isSafe(r, j)){
                board[r][j] = 1;
                //recurrsion
                backtrack(r+1);
                //backtrack
                board[r][j] = 0
            }
        }

    }

    function isSafe(r, c){
        //col up
        for(let i = 0 ; i <= r; i++){
            if(board[i][c] == 1) return false
        }
        let i = r; let j = c;
        //diagonal up left
        while(i >=0 && j >= 0){
            if(board[i][c] == 1) return false
            i--;j--;
        }
        i = r; j = c;
        //diagonal up right
        while(i >=0 && j < m){
            if(board[i][c] == 1) return false
            i--;j++;
        }
        return true;

    }
};