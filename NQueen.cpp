/*
Intuition: Get all possible combinations.
Iterate on cols using the for loop. Iterate on rows using recursion.
Make sure that the queen is in a valid location by checkin diagonals, and vertical positions.

//////////////////////////////////////////////
Time and space complexity is same for both patterns
Time Complexity: O(N!)
Space Complexity: O(N*2)
//////////////////////////////////////////////
*/

class Solution {
public:
    vector<vector<int>> board;
    vector<vector<string>> result;
    int rows;
    int cols;
    vector<vector<string>> solveNQueens(int n) {
        board.resize(n, vector<int>(n, 0));
        rows = n;
        cols = n;
        
        backtrack(n, 0);
        return result;
    }
    
    void backtrack(int n, int r){
        
        if ( r == n){
            vector<string> partialResult = convertBoardToString();
            result.push_back(partialResult);
            return;
        }
        
        for ( int c =0; c < n; c++){
            if(canBePlaced(r, c)){
                board[r][c] = 1;
                backtrack(n, r+1);
                board[r][c] = 0;
  
            }
        
        }
        
    }
    bool canBePlaced(int r, int c){
    
        for( int i =0; i < r;  i++){
            if (board[i][c]== 1) return false;
        }
        
        int k = r;
        int l = c;
        while ( k >=0 and l < cols ){
            if (board[k][l]== 1) return false;
            k--;
            l++;
        }
        
        
        k = r;
        l = c;
        while ( k >=0 and l >= 0 ){

            if (board[k][l]== 1) return false;
            k--;
            l--;
        }
        
        return true;
    }
     vector<string> convertBoardToString(){
         vector<string> paritalResult;
         
         for ( int i =0; i < rows; i ++){
            vector<char> newString;
            for ( int j =0; j < cols; j ++){
                if (board[i][j] == 1){
                    newString.push_back('Q');
                }
                else{
                    newString.push_back('.');
                }
            }
            string s( newString.begin(), newString.end() );
            paritalResult.push_back(s);      
         }
         return paritalResult;         
    }
    
};