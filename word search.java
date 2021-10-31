//Time complexity:-O(n*4^n)
//Spacecomplexity:- 0(1).
//Did it run on leetcode:- yes.
//What was the problem you faced?:- got stackoverflow many times.
//your code with explanation: at first first letter is searched in a matrix for starting point .After searching in given directions by using
//directional array if found applying backtracking. before backtracking in order not to visit again we store in temp for not orginal loss
//in case after backtracking.After this we mark it as * and if there is no element then undoing by changing value to orginal from temp.

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    if(existhelper(board,i,j,0,word)){
                        return true;
                    }
                    
                }
            }
        }
    return false;}
    private boolean existhelper(char[][] board,int i,int j,int index,String word){
        if(index==word.length()-1){
            return true;
        }
        
        int[][] dirs={{0,1},{1,0},{-1,0},{0,-1}};
        char temp=board[i][j];
         board[i][j]='*';
        for(int[] dirs1:dirs){
            int r=i+dirs1[0];
            int c=j+dirs1[1];
            if(r>=0 && c>=0&& r<board.length && c<board[0].length && board[r][c]==word.charAt(index+1)){
                if(existhelper(board,r,c,index+1,word)){
                    return true;
                }
                
            }
        }
        board[i][j]=temp;
        return false;
        }
}