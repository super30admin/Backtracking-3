//Have a dir array
//Call helper from every index
//In helper - check all neighbour blocks with index array
//If mataches with word characters - return true
//TC: O(m * n * 4^L) where L = word.length()
//SC: O(d)


class Solution {
    int[][] dir;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        this.dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        this.flag=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (flag) return true; 
                helper(board,word,0,i,j);
            }
        }
        
        return flag;
        

        
    }
    private void helper(char[][] board,String word, int index, int r, int c){
        if(flag) return;

        //base logic
        if(r<0 || c<0 || r>=board.length || c>=board[0].length){
            return;
        }
        if(board[r][c]!=word.charAt(index)) return;
        
        if(index==word.length()-1){
            flag=true;
            return;
        }

        
        board[r][c]='#';
        
        //actual logic
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];

            helper(board,word,index+1,nr,nc);
            
        }
        board[r][c]=word.charAt(index);
    }
}
