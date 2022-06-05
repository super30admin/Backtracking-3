TC = O(N 3^L) 
SC = O(L)

    If the length of the "word" is greater than the size of the "board" (#rows * #cols) we can simply return False. 
    Also, we can check if each character in "word" exists in "board", if there is at least one character that does not exist
    in "board" we can simply return False. Performing these two prunings we can return False immediately instead of computing further.
        
class Solution {
public:
    int m,n;
    vector<vector<int>> dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        if(m==0) return false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,i,j,0)) return true;   
            }
        }
        return false;
    }
    
    bool backtrack(vector<vector<char>>& board, string word, int i, int j, int index){
        //base
        if(index==word.size()) return true;
        if(i<0 || j<0 || i==m || j==n || board[i][j]=='#'){
            return false;
        }
        
        //logic
        if(board[i][j]==word[index]){
            //action
            char c = board[i][j];
            board[i][j]='#';
            
            //recurse
            for(int k = 0; k < dirs.size(); k++)
            {
                int nr = i + dirs[k][0];
                int nc = j + dirs[k][1];
                if(backtrack(board,word,nr,nc,index+1))
                    return true;
            }
            //backtrack
            board[i][j]=c;
        }
        return false;
    }
};
