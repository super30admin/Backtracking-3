// Time Complexity : O(n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
    

public:
    
    vector<vector<string>> result;
    vector<vector<string>> solveNQueens(int n) {
    
        
        //edge
        if(n==0){
            return result;
        }
        if(n==1){
            vector<string> temp {"Q"};
            result.push_back(temp);
            return result;
        }
        
        string str;
        for(int i=0; i<n;i++){
            char c= '.';
            str.push_back(c);
        }
        
        vector<string> temp(n, str);
        
        backtracking(temp, n, 0);
        
        return result;
        
    }
    
        
   
    
    
    void backtracking(vector<string>& temp, int queens, int row){
        
        // base case
        if(row == queens){
            // we got a valid solution
            result.push_back(temp);
            return;
        }
        
        
        // recursive code.. wehre we place the queen in each row.
        
        
        for ( int j = 0; j < queens; j++){
            
            if(isBoardValid(queens,row,j,temp)){
                
                temp[row][j]  = 'Q'; // setting the queen in a position
                backtracking(temp, queens, row+1); // traverse wiith this potions to move further
                temp[row][j] = '.'; // if this path is not valid then we replace the king with '.' again
            }
        }
    }
    
    

    
    
    bool isBoardValid(int n, int row, int col, vector<string>& temp){
        
    
        
        // here we will check all the table with if the previous queen in same row or colums or diagonally same line...
        
        
        
        // checking the upper rows if we have any queens in the same column
        
     for(int r=0; r<row; r++){
            string str= temp[r];
            if(str[col] == 'Q')
                return false;
        }
        
        
         // checking right diagonal
        
       int r=row-1;
        int c=col-1;
        while(r>=0 && c>=0){
            string str=temp[r];
            if(str[c] == 'Q')
                return false;
            r--; c--;
        }
        
        // checking left diagonal
        
            r=row-1;
        c=col+1;
        while(r>=0 && c<n){
            string str=temp[r];
            if(str[c] == 'Q')
                return false;
            r--; c++;
        }
        return true;
    }
    
    
    
};