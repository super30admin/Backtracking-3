// Time Complexity : O(mn x 3^L) , L being length of the string
// Space Complexity : O(L) // Stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// Finding out the action, recurse and backtrack part was a bit tricky at first
// Your code here along with comments explaining your approach
//1. Find find characted and recurse for the entire length of the string
//2. Backtrack if the string is not found
//3. Return true if the string is found.

class Solution {
public:
    int m, n;
    bool exist(vector<vector<char>>& board, string word) {
        //edge
        if(board.size()==0 && word.length()==0){
            return true;
        }
        if(board.size()==0 && word.length()!=0){
            return false;
        }
        //logic
        m = board.size(); n = board[0].size();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(word[0] == board[i][j]) {
                    if(word.length() == 1) return true;
                    if(backtrack(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }
    
    bool backtrack(vector<vector<char>>& board, string& word, int index, int row, int col){
        //return condition
        if(index==word.length()){
            return true;
        }
        if(board[row][col] != word[index]){
            return false;
        }
        //logic
        vector<vector<int>> dir{{1,0},{-1,0},{0,1},{0,-1}};
        char c = board[row][col] ;
        
        //action
        board[row][col] = '*';
        //recurse
        for(int k=0; k<dir.size();k++){
            int r = row+dir[k][0];
            int c = col+dir[k][1];
            if(r>=0 && r<m &&c>=0 && c<n){
                if(backtrack(board, word, index+1, r, c))  return true;
            }
          }
        //backtrack
        board[row][col] = c;
        
        return false;
    }
};
