// Time Complexity :O(n*3^L) where L is the length of the word
// Space Complexity : O(L) where L is the length of the word  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int m,n;
public:
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board,i,j,word, 0)) return true;
            }
        }
        return false;
    }
    bool backtrack(vector<vector<char>>& board, int i, int j, string word, int index){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#') return false;
        //logic
        int dirs[4][2] = {{0,1},{1,0},{-1,0},{0,-1}};
        //char temp;
        if(word[index] == board[i][j]){
            char temp = board[i][j];
            board[i][j] = '#';
            for(auto dir : dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board,r,c,word,index+1)) return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
    
};