// Time Complexity : O(MN)
// Space Complexity : O(MN)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Loop through grid, whenever the first character matches peform recursion with backtracking
Since, its a grid, we need to seach on 4 sides and mark the visited grid blocks with ' '
If the word is found in anyone dir then return true.
finally if the index==word.len return true
*/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word.length()==0) return false;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && helper(board,word,i,j,0))
                    return true;
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int i,int j,int count){
        if(count==word.length()) return true;

        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || board[i][j]!=word.charAt(count))
            return false;

        char temp=board[i][j];
        board[i][j]=' ';

        boolean found=helper(board,word,i+1,j, count+1) ||
                helper(board,word,i-1,j, count+1) ||
                helper(board,word,i,j+1, count+1) ||
                helper(board,word,i,j-1, count+1);

        board[i][j]=temp;

        return found;
    }
}
