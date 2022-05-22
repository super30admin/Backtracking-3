// Time Complexity : O(n!) where n = size of i/p
// Space Complexity : O(n*n) where n = size of i/p
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
/* Backtracking approach. Perform exhaustive search - try every possible queen placement. 
 * While placing a queen at a cell check column, upper left diagonal and upper right diagonal for a queen.
 * If row value is same as n then capture the board state in the solutions vector. 
 */

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<bool>> board;
    
    vector<vector<string>> solveNQueens(int n) {
        if (n == 0)
        {
            return result;
        }
        
        for (int i = 0; i < n; i++)
        {
            vector<bool> temp;
            for (int j = 0; j < n; j++)
            {
                temp.push_back(false);
            }
            board.push_back(temp);
        }
        
        backtrack(0);
        return result;
    }
    
    void backtrack(int row)
    {
        // base case.
        if (row == board.size())
        {
            vector<string> answer;
            
            for (int i = 0; i < board.size(); i++)
            {
                string temp = "";
                for (int j = 0; j < board.size(); j++)
                {
                    if (board[i][j])
                    {
                        temp += 'Q';
                    }
                    else
                    {
                        temp += '.';
                    }
                }
                answer.push_back(temp);
            }
            
            result.push_back(answer);
            return;
        }
        
        // Logic 
        for (int j = 0; j < board.size(); j++)
        {
            if (isSafe(row, j))
            {
                board[row][j] = true;
                backtrack(row + 1);
                board[row][j] = false;
            }
        }
    }
    
    bool isSafe(int row, int col)
    {
        // 1. Column check
        for (int j = row; j >= 0; j--)
        {
            if (board[j][col])
            {
                return false;
            }
        }
        
        // 2. Upper left diagonal
        int r = row, c = col;
        while (r >= 0 && c >= 0)   
        {
            if (board[r][c])
            {
                return false;
            }
            r--;
            c--;
        }
        
        // 3. Upper right diagonal
        r = row, c = col;
        
        while (r >= 0 && c < board.size())
        {
            if (board[r][c])
            {
                return false;
            }
            r--;
            c++;
        }
        
        return true;
    }
};