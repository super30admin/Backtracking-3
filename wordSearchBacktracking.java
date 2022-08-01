//Time Complexity : o(m*n*3^Length of the word)
//space complexity:O(Length of the word) because we are using recursion =O(L)
//Google ,Amazon and Saleforce

//consider same letter be more than once.As if move forward don't find the solution then we need to go back.By using DFS start traversing to all the elements in matriz.Taking example ABAB and  start checking from initial point and if it found then mark it as visited in recursion and check again for 'B' in grid and then mark it as visited if not found then come back and return convert visited node 1->0 in backtracking.In BFS will be mark it has visited and in recursion will be removing visited array.The time complexity backtracking comesit goes to exponential.
class Solution {
    int[][] dirs;
    int m,n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0)return false;
        
        dirs = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};//UDRL
        m = board.length;
        n = board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][] board,String word,int r,int c, int index){
        //base
        if(index == word.length()) return true;
        if(r<0 || c<0 || r==m || c==n || board[r][c] == '0') return false;
        
        //logic
        if(word.charAt(index) == board[r][c]){
            //action
            char ch = board[r][c];
            board[r][c] = '#';
            for(int[] dir: dirs){
                int nr = r+dir[0];
                int nc = c+dir[1];
                //recurse
                if(backtrack(board,word,nr,nc,index+1)){
                    return true;
                }
            }
            //backtrack
            board[r][c] = ch;
        }
        return false;
    }
}