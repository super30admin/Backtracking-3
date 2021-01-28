/*
Intuition - how to proceed?
Why backtracking? seems like a simple DFS problem
Is there any backtracking? 
Not at every instance
Some other scenarios, there are conflicts
The mistake is not changing visited -> unvisited for DFS
Use a temp variable instead of extra space
- N is number of elements in the matrix
- L is length of string
Time complexity : 
- O(N*(3^L))
Solution is DFS with backtracking.
Space Complexity:
- Including stack space
- O(N)

*/

class Solution {
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(backtrack(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, int i, int j, int index){
        //base
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i == m || j == n || board[i][j] == '#') return false;
        //logic
        int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        if(word.charAt(index) == board[i][j]){
            char temp = board[i][j];
            //action
            board[i][j] = '#';
            for(int[] dir: dirs){
                int r = i + dir[0];
                int c = j + dir[1];
                if(backtrack(board,word,r,c,index+1)){
                    return true;
                }
            }
            //backtrack
            board[i][j] = temp;
            
        }
        return false;
    }
}



