//Time Complexity :O(N^2*3^N)
//Space Complexity :O(1) + recursion stack.
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class WordExists {
	  public boolean exist(char[][] board, String word) {
	        if(null == word || word.length() == 0 || null == board || board.length == 0){return false;}
	        int dirs[][] = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[0].length; j++){
	                if(board[i][j] == word.charAt(0)){
	                    if(dfs(board,i,j,0,word, dirs)){return true;}
	                }
	            }
	        }
	        return false;
	    }
	    private boolean dfs(char[][] board, int i, int j,int index, String word, int[][] dirs){
	        if(i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] != '`'){
	            char ch = board[i][j];
	            if(ch == word.charAt(index)){
	                if(index == word.length()-1){
	                    return true;
	                }
	                board[i][j] = '`';
	                for(int dir[]: dirs){
	                  int newI = i + dir[0];
	                  int newJ = j + dir[1];
	                    if(dfs(board,newI,newJ,index+1,word,dirs)){
	                        return true;
	                    }
	                }
	                board[i][j] = ch;
	            }
	        }
	        return false;
	    }
}