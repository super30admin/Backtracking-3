// Time Complexity : O(N!)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    List<List<String>> result;
    int m;
    HashSet<Integer> colSet;
    HashMap<Integer,Integer> rowToColMap;
    HashSet<Integer> diag1Set;
    HashSet<Integer> diag2Set;
    
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>(); // Answer to be returned
        colSet = new HashSet<>(); // O(N)
        rowToColMap = new HashMap<>();
        diag1Set = new HashSet<>();// O(2N-1)
        diag2Set = new HashSet<>();// O(2N-1)
        m = n;
        helper(0); // At most N Queens so stack height will be O(N)
        return result;
        
    }
    private void addBoardToResult(){
        List<String> answer = new ArrayList<>();
            for(int i = 0 ; i < m ; i++){
                StringBuilder temp = new StringBuilder("");
                for(int j = 0 ; j < m ; j++){
                    if(rowToColMap.get(i)==j) temp.append('Q');
                    else temp.append(".");
                }
                answer.add(temp.toString());
                }
            result.add(answer);
    }
    private void helper(int r){
        // Base Case
        if(r == m){
            addBoardToResult();
            return;
            }
        
        //recursion
        for(int c = 0 ; c < m ; c++){
            if(isSafe(r,c)){
                
                colSet.add(c);
                rowToColMap.put(r,c);
                diag1Set.add(r-c);
                diag2Set.add(r+c);
                
                helper(r+1);
                
                colSet.remove(c);
                rowToColMap.remove(r);
                diag1Set.remove(r-c);
                diag2Set.remove(r+c);
            }
        }
    }
        
        
    
    private boolean isSafe(int r,int c){
        return !colSet.contains(c) && !diag1Set.contains(r-c) && !diag2Set.contains(r+c);
    }
}