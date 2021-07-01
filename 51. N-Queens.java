class Solution {
    // Time complexity: O(n!)
    // Space complexity: O(n^2)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        
        if(n <= 0){
            return results;
        }
        
        search(results, new ArrayList<>(), n);
        return results;
    }
    
    public void search(List<List<String>> results, List<Integer> cols, int n){
        if(cols.size() == n){
            results.add(drawChessboard(cols));
            return;
        }
        
        for(int colIndex = 0; colIndex < n; colIndex++){
            if(!isValid(cols, colIndex)){
                continue;
            }
            
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
            
        }
    }
    
    public boolean isValid(List<Integer> cols, int colIndex){
        int row = cols.size();
        
        for(int rowIndex = 0; rowIndex < cols.size(); rowIndex++){
            if(cols.get(rowIndex) == colIndex){
                return false;
            }
            if(cols.get(rowIndex) + rowIndex == row + colIndex){
                return false;
            }
            if(cols.get(rowIndex) - rowIndex == colIndex - row){
                return false;
            }
        }
        return true;
    }
    
    public List<String> drawChessboard(List<Integer> cols){
        List<String> chessboard = new ArrayList<>();
        for(int row = 0; row < cols.size(); row++){
            StringBuilder sb= new StringBuilder();
            for(int col = 0; col < cols.size(); col++){
                sb.append(cols.get(row) == col? 'Q': '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
}