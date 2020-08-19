//Time Complexity O(3^n) 
//Space Complexity O(length of word)
class WordSearch{
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ;j++){
                if(dfs(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i , int j,int index){//index is for word
        //base
        if(index == word.length())return true;
        if(i <0 || j <0 || i>= board.length || j >= board[0].length || board[i][j] == '.')
            return false;
        //logic
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        if(board[i][j] == word.charAt(index)){
            char temp = board[i][j];
            board[i][j] = '.';
           for(int[] dir : dirs){
               int r = dir[0]+i;
               int c = dir[1]+j;
               if(dfs(board,word,r,c,index+1)) return true;
           }
            board[i][j] = temp;
        } 
    return false;

    }
    public static void main(String args[]) {
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        }
          , "ABCCED"));
    }
}