/**
 * Time complexity:
 * O(N!). Because with each choice of the placement of queen,
 * we are getting N-2, N-4, N-6 choice in subsequent rows.
 */


/**
 * Space Complexity:
 * O(n^2) because we created board of n*n size for calculation.
 */

/**
 * Backtracking Approach:
 * We are given n queens, so we are creating a n*n board. We are creating
 * the board of type bool to simplify the process. Since, we are
 * checking row-wise the placement of the queens, we do not need columns
 * in helper function. To check whether a queen can be placed in a particular
 * cell or not we need to check the column in upward direction only as we
 * are going from top to bottom in the rows and once one queen is placed
 * in a row, we cannot put another queen in the same row. We also have to
 * check diagonals in the upward direction only for the same reason explaine
 * above. If we get the cell where we can place our queen we mark it with
 * "Q", otherwise it is marker with ".". Then we recurse and then backtrack
 * again.
 */

//The code ran perfectly on leetcode.

class Solution {
    int N;
    vector<vector<string>> result;
    vector<vector<bool>> board;
public:
    vector<vector<string>> solveNQueens(int n) {
        board.resize(n, vector<bool> (n));
        N = n;
        helper(0);
        return result;
    }
    
    private:
    void helper(int i){
        //base
        if(i == N){
            vector<string> dSol;
            for(int k = 0; k < N; k++){
                string sub;
                for(int l = 0; l < N; l++){
                    if(board[k][l]){
                        sub.append("Q");
                    } else {
                        sub.append(".");
                    }
                }
                dSol.push_back(sub);
                
            }
            result.push_back(dSol);
        }
        //logic
        for(int j = 0; j <N; j++){
            if(isSafe(i,j)){
                board[i][j] = true;
                helper(i+1);
                board[i][j] = false;
             } 
        }
    }
    
    bool isSafe(int r, int c){
        //column up
        for(int i =0; i<=r; i++){
            if(board[i][c]) return false;
        }
        int i = r;
        int j = c;
        //up left diagonal
        while(i>= 0 && j >= 0){
            if(board[i][j]) return false;
                i--;
                j--;
            }
        i = r;
        j = c;
        while(i>= 0 && j < N){
            if(board[i][j]) return false;
                i--;
                j++;
        }
        return true;
    }
};