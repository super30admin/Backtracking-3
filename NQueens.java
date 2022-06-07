// space Space complexity: O(N*N)
// time : o(n!) 
class Solution {
   
        int size;
   private List<List<String>> solutions = new ArrayList<List<String>>();    
    public List<List<String>> solveNQueens(int n) {
        size =n;
        
        char emptyBoard[][] = new char[size][size];
        for(int i =0; i<n;i++){
            for ( int j =0; j<n;j++){
                       emptyBoard[i][j]= '.'; 
                }
        }
       
        backtrack(0, new HashSet<Integer>(),new HashSet<Integer>(),new HashSet<Integer>(),emptyBoard);
        return solutions;
    }
    
    public void backtrack(int row , Set<Integer> diagnols, Set<Integer> antidiagnols, Set<Integer>  cols, char[][] state){
        
        //base case
        if(row==size){
            // we ll fill up the matrix
            solutions.add(createBoard(state));
            return;
        }
        
        for(int col =0;col<size ;col++){

            int currDiag = row -col;
            int antiDiag = row + col;
            
            if(diagnols.contains(currDiag)  || antidiagnols.contains(antiDiag) || cols.contains(col)){
                continue;
            }
            
            cols.add(col);
            diagnols.add(currDiag);
            antidiagnols.add(antiDiag);
            state[row][col]='Q';
            
            backtrack(row +1 , diagnols,antidiagnols,cols, state);
            
            
            cols.remove(col);
            diagnols.remove(currDiag);
            antidiagnols.remove(antiDiag);
            state[row][col] ='.';
            
        }
        
    }
    
    
    public List<String> createBoard(char [][] state){
        List<String> board = new ArrayList<String>();
        for(int row = 0; row<size; row++){
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        return board;
    }
}
