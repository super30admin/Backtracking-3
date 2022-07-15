// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        
        //for loop for all rows
        //maintain columns hashset to keep track of used columns
        //main diagonals hashset to keep track of used digonals
        //main anti-diagonals hashset to keep track of used anti-digonals
        res = new ArrayList<>();
        if(n==1) {
            List<String> temp = new ArrayList<>();
            temp.add("Q");
            res.add(temp);
            return res;
        }
        
        placeQueens(n, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>(), 0, new ArrayList<String> ());
        
        return res;
    }
    
    private void placeQueens(int n, Set<Integer> columns, Set<Integer> diagonals, Set<Integer> antiDiagonals, int row, List<String> temp) {
        //base case
        if(row==n) {
            //add to result
            res.add(new ArrayList<>(temp));
            return;
        }

        char[] ch = new char[n];
        Arrays.fill(ch,'.');
        
        //logic
        for(int col=0 ; col<n ; col++) {
            int diagonal = row - col;
            int antidiagonal = row + col;
            if(!columns.contains(col) && !diagonals.contains(diagonal) && !antiDiagonals.contains(antidiagonal)) {
                //choose point as queen
                ch[col] = 'Q';
                String rowString = new String(ch);
                temp.add(rowString);
                
                //action
                columns.add(col);
                diagonals.add(diagonal);
                antiDiagonals.add(antidiagonal);
                
                //recurse
                placeQueens(n, columns, diagonals, antiDiagonals, row+1, temp);
                
                //backtrack
                columns.remove(col);
                diagonals.remove(diagonal);
                antiDiagonals.remove(antidiagonal);
                
                //remove Queen
                ch[col] = '.';
                temp.remove(temp.size()-1);
            }
        }
        
    }
}
