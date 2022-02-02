// Time Complexity : O(m * n * 3^L) l=> length of the string
// Space Complexity : O(L)
class Solution {
    int dirs[][];
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board==null || board[0].length==0)
            return false;
        m=board.length;
        n=board[0].length;
        dirs=new int [][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,i,j,0,word))
                    return true;
            }
        }
        return false;
    }
    private boolean backtrack(char [][]board, int i, int j, int index, String word){
        //base case
        if(index==word.length())
            return true;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='#')
            return false;
        //logic case
        if(board[i][j]==word.charAt(index)){
            char ch= board[i][j];
            //action
            board[i][j]='#';
            for(int dir[]:dirs){
                int r=dir[0]+i;
                int c=dir[1]+j;
                //recursion
                if(backtrack(board,r,c,index+1,word))
                    return true;
            }
            //backtracking
             board[i][j]=ch;
            
        }
        return false;
    }
}
