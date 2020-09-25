// Time Complexity : O(mn x 3^L) , L being length of the string
// Space Complexity : O(L) // Stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        
        if(board.size()==0 && word.length()==0){
            return true;
        }
        if(board.size()==0 && word.length()!=0){
            return false;
        }
        
        for ( int i = 0; i < board.size() ; i++){
            
            for( int j = 0; j < board[0].size(); j++){
                
                if(board[i][j]== word[0]){
                 
                    if(backtracking(board, i, j, word,0)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    
   
    
    bool backtracking( vector<vector<char>>& board, int i, int j, string& word, int index){
        
        // base case
         
        if(index>= word.size()-1){
            
            return true;
        }
        
      
        
        vector<vector<int>> directions{{0,1}, {0,-1},{1,0}, {-1,0}}; // directions array
        char temp = board[i][j];
        
        board[i][j] = '#'; // so that this avoids travelling the same posiition again. We can also use visited not visited table as well
        
        for ( int k = 0; k < directions.size(); k++){
            int r = i + directions[k][0];
            int c = j + directions[k][1]; // moving in the direction
            
            // checking for out of bound and alsow whether the next element is same as next element in word.
            if( r >=0 && r < board.size() && c >=0 && c < board[0].size() && (index+1 < word.size() && word[index+1] == board[r][c]) ){
                  cout<<"umar"<<endl;
                if(backtracking( board, r, c, word, index+1)){ // recursive calling function
                    
                 return true;   
                }
            
        }
        
   
        }
    board[i][j] = temp;  // backtracking
    return false;
    }
};