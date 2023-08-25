package problems.backtrack;
//TC : O(m*n*(3^L))
//SC = L..length of word for recursion stack

public class Problem79 {
    int m;
    int n;
    int[][] dirs;
    boolean flag;
    public boolean exist(char[][] board, String word) {
        this.m=board.length;
        this.n=board[0].length;
        this.dirs= new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        this.flag=false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                backtrack(board,word,i,j,0); //call the backtrack function on all the elements
            }
        }
        return flag;
    }

    private void backtrack(char[][] board, String word, int r, int c, int idx){
        //base case
        //if we are able to reach at the last index, it means we found the word. So set the flag true and return
        if(idx==word.length()){
            flag=true;
            return;
        }
        //check the border before moving ahead along with if the element is already visited previously
        if(r<0 || r==m || c<0 || c==n || board[r][c]=='#')
            return;
        //logic
        //if we find the character match, then only we will proceed further
        if(board[r][c]==word.charAt(idx)){
            //mutate the value to maintain the visited element
            board[r][c]='#';
            //iterate in all direction for BFS and recurse
            for(int[] dir: dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                //recurse
                //pass new row and column value along with next index for next character
                backtrack(board,word,nr,nc,idx+1);
            }
            //backtrack
            //update the mutated value
            board[r][c]=word.charAt(idx);
        }

    }

    public static void main(String[] args) {
        Problem79 problem=new Problem79();
        char[][] input =new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(problem.exist(input,"ABCCED"));
        System.out.println(problem.exist(input,"BASE"));
    }
}
