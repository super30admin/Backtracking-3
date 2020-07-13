//Time Complexity : O(4^L*N)
// Space Complexity :O(n*n) because of the visited array vector created 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
class Solution {
public:
    void make_visitedAll_false(vector<vector<char>>& board, vector<vector<bool>>& visited){
        for(int i=0; i<board.size(); i++){
            vector<bool> temp;
            for(int j=0; j<board[i].size(); j++){
                temp.push_back(false);
            }
            visited.push_back(temp);
        }
    }
    
    bool word_check(vector<vector<char>>& board, vector<vector<bool>>& visited, int row, int col, string word){
        
        if(word.size()==0 ) return true;
        
        if(row<0 || col<0) return false;
        
        if(row>=board.size() || col >= board[0].size()) return false;
        
        if(visited[row][col]==true) return false;
        
        
        bool res0=false, res1=false, res2=false, res3=false;
        
        if(board[row][col]==word[0]){
            
            visited[row][col]=true;
            string sub_str="";
           
            //creating substring
            for(int i=1; i<word.size(); i++){
                sub_str+=word[i];
            }
            
            res0 = word_check(board, visited, row-1, col, sub_str);
            if(res0==true) return true;
            res1 = word_check(board, visited, row+1, col, sub_str);
            if(res1==true) return true;
            res2 = word_check(board, visited, row, col-1, sub_str);
            if(res2==true) return true;
            res3 = word_check(board, visited, row, col+1, sub_str);
            if(res3==true) return true;
            
            //backtrack visited 
            visited[row][col]=false;
        }
        
        return false;
    }
    
    bool exist(vector<vector<char>>& board, string word) {
        vector<vector<bool>> visited;
        make_visitedAll_false(board, visited);
        
        int row = board.size();
        int col = board[0].size();
        
        for(int i=0; i<row; i++){
            bool flag = false;
            for(int j=0; j<col; j++){
                bool res = word_check(board, visited, i, j, word);
                if(res==true){
                    return true;
                }
            }
            
        }
        
        return false;
    }
};