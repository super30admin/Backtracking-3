//TC: O(N!) 
//SC: O(N^2)


class Solution {
public:
    
    vector<vector<string>> output;
    
    int boardDim;
    
    //to check for if a position is valid or not.
    bool isValid(vector<string> &board, int i, int j){
        
        //checking for only up, left up diag and right upper diag since we are
        //only adding new queens from the next row onwards.
        //check for up
        int r = i;
        int c = j;
        
        while(r >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
        }
        
        //check for left diagonal
        //reset r,c
        r = i; c = j;
        while(r>= 0 && c >= 0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }
        
        
        //check for right diagonal
        r=i; c=j;
        while(r>=0 && c<boardDim){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c++;
        }
        
        
        return true;
        
        
    }
    
    
    //board, number of queens, next row to traverse to.
    void backtrack(vector<string> &board, int n, int i){
        if(n==0){
            output.push_back(board);
            return;
        }
        
        for(int j=0; j<boardDim; j++){
            if(isValid(board, i, j)){
                board[i][j] = 'Q';
                backtrack(board, n-1, i+1);
                //backtracking is simply changing 'q' to a '.'
                board[i][j] = '.';
            }
        }        
    }
    
    
    vector<vector<string>> solveNQueens(int n) {
        
        if(n == 0)
            return output;
        
        boardDim = n;
        
        //creating vector with size n, and all values as string(n, '.')
        //each string is of length n, and initialized with '.'
        vector<string> board(n,string(n,'.'));
        
        backtrack(board, boardDim, 0);
        
        return output;
        
        
    }
};