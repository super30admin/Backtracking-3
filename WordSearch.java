public class WordSearch {
    int m;
    int n;
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0) return false;
        m=board.length;
        n=board[0].length;
        dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(helper(board,word,i,j,0)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word,int i,int j,int index){
        //base
        if(index==word.length()) return true;
        if(i<0||j<0||i==m||j==n||board[i][j]=='#') return false;
        //logic
        if(board[i][j] == word.charAt(index)){
            //action
            char c = board[i][j];
            board[i][j] = '#';
            for(int[] dir:dirs){
                int nr = i+dir[0];
                int nc = j+dir[1];
                //recurse
                if(helper(board,word,nr,nc,index+1)) return true;
            }
            //backtrack
            board[i][j] = c;
        }
        return false;
    }
}
