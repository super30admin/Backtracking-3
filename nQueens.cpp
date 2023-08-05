class Solution {
    vector<vector<string>> result;

public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<bool>> board(n, vector<bool>(n,false));
        helper(board,0, n);
        return result;

        
    }

    void helper(vector<vector<bool>> board, int r,int n){
        //base case
        if(r==n){
            vector<string> sol;
            for(int i=0;i<n;i++){
                string row = "";
                for(int j=0;j<n;j++){
                    if(!board[i][j]){
                        row.push_back('.');
                    }
                    else{
                        row.push_back('Q');

                    }
                }
                sol.push_back(row);

            }

            result.push_back(sol);

            


            

        }

        //logic
        for(int j =0; j<n;j++){
           if(isSafe(board, r, j)){
               board[r][j]=true;

               helper(board,r+1,n);

               board[r][j]=false;



           }
        }

    }

    bool isSafe(vector<vector<bool>> board,int r, int c){
        int n = board.size();
        for(int i=0;i<=r;i++){
            if(board[i][c]){
                return false;
            }
        }

        int i=r;int j=c;
        while(j>=0 && i>=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j--;

        }
        i=r;j=c;
        while(j<n && i>=0){
            if(board[i][j]){
                return false;
            }
            i--;
            j++;

        }

        return true;




        
        

    }
};