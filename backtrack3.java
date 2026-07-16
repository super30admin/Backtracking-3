//problem1
class Solution {
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        this.ans=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        helper(board,n,0);
        return ans;
    }
    public void helper(boolean[][]board,int n,int row){
        if(row==n){
            List<String> res=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            ans.add(res);
            return;
        }
        for(int j=0;j<n;j++){
            if(isfeasible(board,row,j,n)){
                board[row][j]=true;
                helper(board,n,row+1);
                board[row][j]=false;
            }
        }
    }
    public boolean isfeasible(boolean[][] board,int i,int j,int n){
        int r=i;
        int c=j;
        while(r>=0){
            if(board[r][c]) return false;
            r--;
        }
        r=i;c=j;
        while(r>=0 && c>=0){
            if(board[r][c]) return false;
            r--;c--;
        }
        r=i;c=j;
        while(r>=0 && c<n){
            if(board[r][c]) return false;
            r--;c++;
        }
        return true;
    }
}
//problem 2
class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,0,i,j,dirs))
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board,String word,int index,int i,int j,int[][] dirs){
        if(board[i][j]!=word.charAt(index)) return  false;
        if(index==word.length()-1) return true;
        char temp=board[i][j];
        board[i][j]='#';
        for(int[] dir:dirs){
            int ni=i+dir[0];
            int nj=j+dir[1];
            if(ni>=0 && nj>=0 && ni<board.length && nj<board[0].length && board[ni][nj]!='#'){
                if(helper(board,word,index+1,ni,nj,dirs)){
                return true;
                }
            }
        }
        board[i][j]=temp;
        return false;
    }
}
