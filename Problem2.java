//Time complexity - O(n^2 X n)
//Space complexity - O(word length)
//Ran on leetcode-Yes
//Solution with comments:
class Solution {
    public boolean exist(char[][] board, String word) {
        int index=0;
       boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(backtrack(board,word,i,j,index, visited)){
                    return true;
                     }
                 } 
            }
        return false;
    }
    
    int[][] directions= new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean backtrack(char[][] board, String word, int i , int j, int index, boolean[][] visited){
        
        if(index>word.length()-1){
                return true;
            }

        else if(i>=0 && j>=0 && i<board.length && j<board[0].length && !visited[i][j] &&
                                                            board[i][j]==word.charAt(index)){
            //System.out.println("   "+i+""+j+" index is: "+ index+" "+ (word.length()-1));
            if(index==word.length()-1)
                return true;
            visited[i][j]=true;
            for(int[] dir : directions){
                     int x= i + dir[0];
                     int y= j + dir[1];
                    if( backtrack(board,word,x,y,index+1,visited))
                        return true;
                   
                }
             visited[i][j]=false;
        }
         
        return false;
    }
}