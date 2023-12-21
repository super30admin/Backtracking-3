class Solution {
   
public:
 vector<vector<string>> result;
   vector<vector<bool>> board;
    vector<vector<string>> solveNQueens(int n) {
       this->board[n][n] = {};
       helper(0,n) ;
       return result;
    }
    private:

    void helper(int row, int n)
    {
        //base case

        if(row == n)
        {
            vector<string> temp;
            for(int i = 0; i<n;i++)
            {
                string sb;
                for(int j = 0; j<n;j++)
                {
                    if(board[i][j] )
                    {
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                temp.push_back(sb);
            }

            result.push_back(temp);
            return;
        }

        for(int j = 0;j<n;j++)
        {
            if(isSafe(row,j,n))
            {
                //action
                board[row][j] = true;

                //recurse
                helper(row+1,n);
                //backtrack
                board[row][j] = false;

            }
        }
    }

    bool isSafe(int i,int j,int n)
    {
        int r = i;
        int c = j;

        while(r>=0)
        {
            if(board[r][c])
            return false;
            r--;
        }

        r= i; c = j;
        while(r>=0 && c>=0)
        {
            if(board[r][c])
            return false;
            r--;
            c--;
        }

        r= i; c = j;
        while(r>=0 && c<n)
        {
            if(board[r][c])
            return false;
            r--;
            c--;
        }

        return true;
    }
};