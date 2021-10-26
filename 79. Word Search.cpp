/*
Time Complexity = O(m*n* 3^L)
Space Complexity = O(L)
where m is the number of rows and n is the number of coloumns and L is the length of string word.
*/
class Solution {
public:
    int m,n;
    vector<vector <int>> dir{{0,1},{1,0},{0,-1},{-1,0}};
    bool backtrack(vector<vector<char>>& board, string word, int index, int row, int col)
    {
        //base
        if(index == word.size())
            return true;
        if(row<0 || col<0 || row==m || col==n || word[index]!=board[row][col])
            return false;
        //logic
        
        //action
        char ch = board[row][col];
        board[row][col] = '#';
        //recurse
        if(backtrack(board, word, index+1 , row, col+1)) return true;
        if(backtrack(board, word, index+1 , row, col-1)) return true;
        if(backtrack(board, word, index+1 , row+1, col)) return true;
        if(backtrack(board, word, index+1 , row-1, col)) return true;
        //backtrack
        board[row][col] = ch;
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        int i,j;
        m = board.size();
        n = board[0].size();
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(board[i][j]==word[0])
                    if(backtrack(board, word, 0 , i, j))
                        return true;
            }
        }
        return false;
    }
};
