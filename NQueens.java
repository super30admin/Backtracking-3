/**
 * Time Complexity: O(N ^ N)??
 * Space Complexity: O(N)
 * Runs on Leetcode: Yes
 * Problems: Had trouble checking if board was valid
 */
class Solution {
    
    List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        
        backtrack(n, 0, new ArrayList<String>());
        
        return result;
    }
    
    private void backtrack(int n, int row, List<String> board){
        //base case
        if(row == n) {
            result.add(new ArrayList<>(board));
            return;
        }
        
        for(int i = 0; i < n; i++){
            StringBuilder newString = new StringBuilder();
            for(int j = 0; j < n; j++){
                char c = j == i ? 'Q' : '.';
                newString.append(c);
            }
            board.add(newString.toString());
            if(isValid(board)){
                backtrack(n, row + 1, board);
            }
            board.remove(board.size() - 1);
        }
    }
    
    private boolean isValid(List<String> board){
        int lastRow = board.size() - 1;
        int lastQ = board.get(lastRow).indexOf('Q');
        for(int i = 0; i < board.size() - 1; i++){
            int currentQ = board.get(i).indexOf('Q');
            int diff = Math.abs(currentQ - lastQ);
            if(diff == 0 || lastRow - i == diff ) return false;
        }
        return true;
    }
    
}