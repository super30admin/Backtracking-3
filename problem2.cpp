//Can you let me know the complexitites of this?
//Space complexitites - O(n)
class Solution {
public:
    int m,n;
    vector<vector<int>>dirs={{0,1},{0,-1},{1,0},{-1,0}};
    bool helper(vector<vector<char>> &board, string &word, int idx, int row,int col){
        if(idx==word.size()){
            return true;
        }
        if(row<0||col<0||row==m||col==n||board[row][col]!=word[idx]){
            return false;
        }
        char ch = board[row][col];
        board[row][col]='#';
        for(int i = 0; i < dirs.size(); i++){
            int r = row+dirs[i][0];
            int c = col+dirs[i][1];
            if(helper(board,word,idx+1,r,c))
                return true;
        }
        board[row][col]=ch;
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        m=board.size();
        n=board[0].size();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word[0]){
                    if(helper(board,word,0,i,j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
};