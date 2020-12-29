//Time - O(mn*4^len(word)) m,n - num rows, num cols
//Space - O((mn)^2)

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if(board.size() == 0) return false;
        vector<vector<bool>> grid (board.size(),vector<bool>(board[0].size(),false));
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board[i].size();j++){
               if(checkIfItExists(grid,board,word,i,j,0)) return true;
            }
        }
        
        return false;
    }
    
    
    bool checkIfItExists(vector<vector<bool>>& grid, vector<vector<char>>& board, string& word, int r, int c, int idx){
        if(idx == word.size()) {return true;}
        if(r>=grid.size() || r<0 ||  c>=grid[0].size() || c<0) return false;
        
        if(word[idx] == board[r][c] && !grid[r][c]){
            grid[r][c] = true;
            if(checkIfItExists(grid,board,word,r+1,c,idx+1) || checkIfItExists(grid,board,word,r-1,c,idx+1) || checkIfItExists(grid,board,word,r,c+1,idx+1) || checkIfItExists(grid,board,word,r,c-1,idx+1)) return true;
            grid[r][c] = false;
            
        }
        
        return false;
                
    }
    
};