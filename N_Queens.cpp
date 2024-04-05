// Apporach 1 : DFS
// Time Complexity : O(n!) 
// Space Complexity : O(n * m) + o(n)
//                   ...... O(n * m) for visiting all elements
//                   ...... O(n)  for call stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
Leetcode : https://leetcode.com/problems/n-queens/description/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two 
queens attack each other. Given an integer n, return all distinct solutions to the n-queens
 puzzle. You may return the answer in any order. Each solution contains a distinct board 
 configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an 
 empty space, respectively.
*/

class Solution {
    vector<vector<string>>result;
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>>board(n, vector<bool>(n, false));
        dfs(0, n, board);
        return result;
    }

    bool isAllowed(int i, int j, int n, vector<vector<bool>> &board){
        //Check column
        int tempI = i-1;
        int tempJ = j;
        while(tempI >= 0){
            if(board[tempI][tempJ]) return false;
            tempI--;
        }

        //check diagonal up left side
        tempI = i-1;
        tempJ = j-1;
        while(tempI >= 0 && tempJ >= 0){
            if(board[tempI][tempJ]) return false;
            tempI--;
            tempJ--;
        }

        //check diagonal up right side
        tempI = i-1;
        tempJ = j+1;
        while(tempI >= 0 && tempJ < n){
            if(board[tempI][tempJ]) return false;
            tempI--;
            tempJ++;
        }
        return true;
    }

    void dfs(int i, int n, vector<vector<bool>> &board){
        //base condition
        if(i == n){
            vector<string>strVector;
            for(int l=0; l<n; l++){
                string str ="";
                for(int m=0; m<n; m++){
                    if(board[l][m]) str+= 'Q';
                    else str += '.';
                }
                strVector.push_back(str);
            }
            result.push_back(strVector);
            return;
        }

        for(int col = 0; col < n; col++){
            if(isAllowed(i, col, n, board)){
                //logic, recursion
                board[i][col] = true;
                dfs(i+1, n, board);
                //backtracking
                board[i][col] = false;
            }
        }


    }
};
