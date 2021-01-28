/*Algorithm :
Iterate the matrix, and at any point if we find the first character of word,
We can start searching from this position
Check the neighbors of current cell for the next character. If matches, 
Put the current cell char in temp variable,
ithen mark as visited and iterate for the next characters of the word 
After this search, backtrack and put the original value back in the cell

Time complexity : O(N. 3^L) -> asymptotically its a exponential time
Space complexity : O(1), as we not using any extra DS to compute


*/

class WordSearch1 {
    int m;
    int n;
    int[][]direction = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board == null)return false;
        
        this.m = board.length;
        this.n = board[0].length;
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(helperSearch(board,word,i,j,0)){
                    return true;
                    }
            }
        }
        return false;
    }
    
    
    private boolean helperSearch(char[][] board, String word,int i, int j, int index){
        //base
        if(index == word.length()){
            return true;
            
        }
        
        if(i < 0 || i >= m || j< 0 || j >= n|| board[i][j] == '#')return false;
        
        
        //logic
        if(board[i][j] == word.charAt(index)){
            //take the char in temp variable
            char temp = board[i][j];
            //mark the cell as visited
            board[i][j] = '#';
            
            //recurse for next by searching neighbors
            for(int[]d : directions){
                int newRow = i + d[0];
                int newCol = j + d[1];
                
                //recurse
                if(helperSearch(board,word,newRow,newCol,index+1)){
                    return true;
                }
                
                
            }
            
            //backtrack
            board[i][j]= temp;
            
        }
    }
}