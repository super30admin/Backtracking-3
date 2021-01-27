// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :No
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//In the below code I took extra space.The code passed most of the test cases but was giving TLE for some.
class Solution {
    private boolean validate;
    public boolean exist(char[][] board, String word) {
        validate=false;
        StringBuilder str=new StringBuilder();
        boolean[][] track=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length && !validate;i++){
            for(int j=0;j<board[i].length && !validate;j++){
                if(board[i][j]==word.charAt(0)){
                    helper(board,str,i,j,word,track);
                }
            }
        }
        
        return validate;
    }
    
    private void helper(char[][] board,StringBuilder makeWord,int i,int j,String word,boolean[][] track){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length ||track[i][j]||makeWord.length()>word.length()){
            return;
        }
        makeWord.append(board[i][j]);
        if(makeWord.toString().equals(word)){
            //System.out.println(makeWord);
            validate=true;
        }
        track[i][j]=true;
        helper(board,makeWord,i,j-1,word,track);
        helper(board,makeWord,i,j+1,word,track);
        helper(board,makeWord,i+1,j,word,track);
        helper(board,makeWord,i-1,j,word,track);
        makeWord.deleteCharAt(makeWord.length()-1);
        track[i][j]=false;
    }
}

// Time Complexity :O(m*n)
// Space Complexity :O(1) //if we don't conside the recursive stack.
// Did this code successfully run on Leetcode :No
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//Here i removed the extra space and rather than making new string at each stage I compared the characters at each point.


class Solution {
    //private boolean validate;
    public boolean exist(char[][] board, String word) {
        //validate=true;
        int index;
        boolean[][] track=new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]==word.charAt(0)){
                    index=0;
                    if(helper(board,i,j,word,index)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean helper(char[][] board,int i,int j,String word,int index){
        if(index==word.length()){
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length ||board[i][j]!=word.charAt(index) ||board[i][j]=='+'){
            return false;
        }
        char temp=board[i][j];
        board[i][j]='+';
        // boolean left=helper(board,i,j-1,word,index+1);
        // boolean right=helper(board,i,j+1,word,index+1);
        // boolean top=helper(board,i+1,j,word,index+1);
        // boolean bottom=helper(board,i-1,j,word,index+1);
        boolean found=helper(board,i,j-1,word,index+1) || helper(board,i,j+1,word,index+1) || helper(board,i+1,j,word,index+1)|| helper(board,i-1,j,word,index+1);
        board[i][j]=temp;
        //return left || right || top || bottom;
        return found;
    }
}




