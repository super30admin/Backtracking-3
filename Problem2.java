//Accepted on LT
//Time should be N! so the idea is to recurse in all directions and backtrack on failing
class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(bct(board,word,i,j,0)) return true;
                }
                
            }
        }

        return false;
        
    }
    public boolean bct(char[][] board, String word,int r ,int c,int idx){
       //base
       if( r<0 || c<0 || r==board.length || c==board[0].length||board[r][c]=='#') return false;
       if(idx==word.length()){
           return true;
       }
        if(board[r][c]==word.charAt(idx)){
            if(idx==word.length()-1) return true;
       
            //action
            board[r][c]='#';;
            //recurse
            for(int[] d :directions ){
                int nr = r + d[0];
                int nc = c + d[1];
                
                if(bct(board,word,nr,nc,idx+1)){
                    return true;
                }

            }
            //bct
            board[r][c] = word.charAt(idx);



        }
        return false;

    }
}