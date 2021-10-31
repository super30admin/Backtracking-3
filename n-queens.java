//Time complexity:-O(n!)
//Spacecomplexity:- 0(n^2).
//Did it run on leetcode:- yes.
//What was the problem you faced?:- got wrong answers many times.
//your code with explanation:at first a nxn charecter array is created and checked move directions if it is valid then change the position
// to q and reccursively called if there is no such place operation is undone.

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] visited = new char[n][n];
        for(int i = 0 ; i < n ; i++)
            Arrays.fill(visited[i] , '.');
        
        helper(0 , visited , n);
        return res;
    }
    
    public void helper(int i , char[][] visited , int n) {
        if(i == n) {
            addResult(visited);
            return;
        }
        
        for(int j = 0 ; j < n ; j++) {
            if(isValidMove(i , j, visited)) {
                visited[i][j] = 'Q';
                helper(i + 1 , visited , n);
                visited[i][j] = '.';
            }
        }
    }
    
    public boolean isValidMove(int i , int j , char[][] visited) {
        int n = visited.length;
        
        // same coloum
        
        for(int r = 0 ; r < i ; r++) 
            if(visited[r][j] == 'Q')
                return false;
        
        // right diagonal 
        int r , c;
        r = i - 1;
        c = j - 1;
        
        while(r >= 0 && c >= 0) {
            if(visited[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        
        // left diagonal 
        r = i - 1;
        c = j + 1;
        
        while(r >= 0 && c < n) {
            if(visited[r][c] == 'Q')
                return false;
            
            r--;
            c++;
        }
        
        return true;
    }
    
    public void addResult(char[][] visited) {
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < visited.length ; i++)
            list.add(new String(visited[i]));
            
         res.add(list);
    }
}