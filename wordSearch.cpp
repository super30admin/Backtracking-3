class Solution {
    bool flag;
    vector<vector<int>> dirs;
    int m;
    int n;
public:
    bool exist(vector<vector<char>>& board, string word) {
        flag=false;
        if(board.size()==0){
            return false;
        }

        
         m= board.size();
         n=board[0].size();

        dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!flag){
                    dfs(board,word,i,j,0);
                }
            }
        }

        return flag;
        
        
    }


    void dfs(vector<vector<char>>& board, string word, int r, int c, int idx){
        
        

        if(idx==word.size()){
            flag=true;
            return;
        }

        if(r<0 || c<0 || r==board.size() || c==board[0].size() || board[r][c]=='#'){
            return;
        }

        if(word[idx]==board[r][c]){
            board[r][c]='#';
            
            for(vector<int> dir:dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(!flag){
                    dfs(board,word,nr,nc,idx+1);
                }
                if(flag){
                    break;
                }

            }

            board[r][c]=word[idx];
            
        }

        




    }
};