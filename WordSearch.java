/*
The time complexity is O(m*n*3^l) where m is board rows, n is board columns and l is the length of the word. The space complexity is O(l)
since we go l-1 depth at max to check if the word matches.

The intuition here is select if the first character of the word is found anywhere in the board matrix. If found we use backtracking to check
all of its neighbours for the second character of the word. We follow this process till all the directions are exausted and we did'nt find
the next character we backtrack. If we reach to the end of the word we return true.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {

    public int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {
        if(word.length()==0){return false;}
        else{
            int rows = board.length; int col = board[0].length;
            boolean[][] visited = new boolean[rows][col];

            for(int i=0;i<rows;i++){
                for(int j=0;j<col;j++){
                    if(board[i][j]==word.charAt(0)){
                        boolean temp = checkBacktrack(board,visited,word,rows,col,i,j,0);
                        if(temp){
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

    public boolean checkBacktrack(char[][] board,boolean[][] visited,String word,int rows,int col,int srow,int scol,int curr){
        if(curr==word.length()){
            return true;
        }

        if(srow<0 || srow >=rows || scol<0 || scol >= col || visited[srow][scol] || word.charAt(curr)!=board[srow][scol]){
            return false;
        }

        visited[srow][scol] = true;

        for(int[] arr:directions){
            int xtemp = arr[0]+srow; int ytemp = arr[1]+scol;
            if(checkBacktrack(board,visited,word,rows,col,xtemp,ytemp,curr+1)){
                return true;
            }
        }

        visited[srow][scol] = false;
        return false;
    }



}