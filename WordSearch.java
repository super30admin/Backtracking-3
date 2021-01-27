class WordSearch {
    HashSet<String> words = new HashSet<>();
    String wrd;
    public boolean exist(char[][] board, String word) {
        wrd = word;
        helper(board, "", 0, 0);
        return words.contains(wrd) ;
    }
    
    private void helper(char[][] board, String path,int index,int jIndex){
        
        if(index >= board.length || jIndex >= board[0].length)return;
        if(path.equals(wrd)){
            words.add(path);
            return;
        }
        
        int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        
        for(int i = index; i < board.length;i++){
            
            for(int j = jIndex; j < board[0].length; j++){
                
                for(int[] dir : dirs){
                    int new_i = dir[0]+i;
                    int new_j = dir[1] +j;
                    
                    if(new_i < board.length && new_i >=0 && new_j < board[0].length && new_j >= 0){
                helper(board, path + board[new_i][new_j], index, jIndex+1);

                    }
                }
                
                
            }
            
        }
    }
}
