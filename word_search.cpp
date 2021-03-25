//TC: O(N*3^L)
//SC: O(L) where L is length of the word to be matched

class Solution {
public:
    
    int numRows;
    int numCols;
    
    vector<pair<int, int>> dirs;
    
    bool backtrack(int row, int col, vector<vector<char>>& board, string &word, int start){
        
        //first case is if start is greater than the word length then we know we have found the word
        if(start >= word.size())
            return true;
        
        
        //second case is if we go out of bounds or the index of the word is not matching to the word.
        //Doing this boundary check here would help us reach the first condition
        if(row >= numRows || row<0 || col<0 || col>=numCols || board[row][col]!=word[start])
            return false;
        
        
                
        bool ret = false;
         
        //set the character in the board to a special character so that it is not reused by an adjacent character.
        board[row][col] = '#';
        
        for(int i=0; i<dirs.size(); i++){
            ret = backtrack(row+dirs[i].first, col+dirs[i].second, board, word, start+1);
            //if the word has been found, return true
            if(ret == true){
                return true;
            }
        }
        
        board[row][col] = word[start];
                
        return false;
        
        
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        
        vector<pair<int, int>> startpoints;
        numRows = board.size();
        numCols = board[0].size();
        
        //we can then explore all the neighbours in a DFS fashion. 

        dirs.push_back({0, 1});
        dirs.push_back({0, -1});
        dirs.push_back({1, 0});
        dirs.push_back({-1, 0});

        
        for(int i=0; i<board.size(); i++){
            for(int j=0; j<board[0].size(); j++){
                if(backtrack(i, j, board, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }
};