//Time complexity : O(n!)
//Space complexity : O(n)
class Solution {
public:
    vector<vector<bool>> board;
    vector<vector<string>> result;
    int max;
    vector<vector<string>> solveNQueens(int n) {
        max = n;
        board.resize(n , vector<bool>(n , false));
        backtrack(0);
        return result;
    }
    
    void backtrack(int row)
    {
        //Base Case
        if(row == max)
        {
            vector<string> res;
            for(int i = 0 ; i < max; i++)
            {
                string temp = "";
                for(int j = 0 ; j < max; j++)
                {
                    if(board[i][j] == true)
                    {
                        temp += 'Q';
                    }
                    else
                    {
                        temp += '.';
                    }
                }
                res.push_back(temp);
            }
            result.push_back(res);
            return;
        }
        
        //Logic
        for(int j = 0; j < max; j++)
        {
            if(isSafe(row,j))
            {
                board[row][j] = true;
                backtrack(row+1);
                board[row][j] = false;
            }
        }
    }
    
    bool isSafe(int i, int j)
    {
        int row = i;
        int col = j;
        
        while(row >= 0)
        {
            if(board[row][j] == true)
                return false;
            row--;
        }
        
        row = i;
        col = j;
        while(row >= 0 && col >= 0)
        {
            if(board[row][col] == true)
                return false;
            row--;
            col--;
        }
        
        row = i;
        col = j;
        while(row >= 0 && col < max)
        {
            if(board[row][col] == true)
                return false;
            row--;
            col++;
        }
        
        return true;
    }
};