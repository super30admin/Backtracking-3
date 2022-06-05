TC = O(n!)
n
n-2
n-4
.
.
.
  
SC = (n^2)  //boolean board 
Recursive calls = O(N)

class Solution {
public:
    vector<vector<string>> result;
    vector<vector<bool>> board;
    int m;
    vector<vector<string>> solveNQueens(int n) {
        if(n==0) return result;
        m=n;
        board.resize(n, vector<bool>(n));
        recursion(board,0);
        return result;
    }
    
    void recursion(vector<vector<bool>> board, int r){
        //base
        if(r==m){
            vector<string> list;
            for(int i=0;i<m;i++){
                string s;
                for(int j=0;j<m;j++){
                    if(board[i][j]) s.push_back('Q');
                    else s.push_back('.');
                }
                list.push_back(s);
            }
            result.push_back(list);
            return;
        }
        //logic
        for(int c=0;c<m;c++){
            if(isClear(board,r,c)){
                board[r][c]=true; //action
                recursion(board,r+1); //recurse
                board[r][c]=false; //backtrack
            }
        }
    }
    
    bool isClear(vector<vector<bool>> board, int r, int c){
        //check same col above
        for(int i=0;i<r;i++){
            if(board[i][c]) return false;
        }
        //diagonal up left
        int i=r; int j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--; j--;
        }
        //diagonal up right
        i=r; j=c;
        while(i>=0 && j<m){
            if(board[i][j]) return false;
            i--; j++;
        }
        return true;
    }
};
