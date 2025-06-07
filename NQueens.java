//Time Complexity :O(n!)
//Space complexity:O(n^2)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        char[][] board=new char[n][n];
        queen(board,list,0);
        return list;
    }
    static void queen(char[][] board,List<List<String>> list,int col){
        if(col==board.length){
            saveBoard(board,list);
            return;
        }
        for(int row=0;row<board.length;row++){
            if(isSafe(board,row,col)){
                board[row][col]='Q';
                queen(board,list,col+1);}
                board[row][col]='.';
        }
    }
    static boolean isSafe(char[][] board,int row,int col){
        for(int j=0;j<board.length;j++){
            if(board[row][j]== 'Q'){
            return false;}
        }
        for(int i=0;i<board.length;i++){
            if(board[i][col]== 'Q'){
            return false;}
        }
        //upper left
        int r=row;
        for(int c=col;c>=0&&r>=0;c--,r--){
            if(board[r][c]== 'Q'){
            return false;}
        }
        //upper right
     r=row;
        for(int c=col;c<board.length&&r>=0;c++,r--){
            if(board[r][c]== 'Q'){
            return false;}
        }
        //lower right
        r=row;
        for(int c=col;c<board.length&&r<board.length;c++,r++){
            if(board[r][c]=='Q'){
            return false;}
        }
        //lower left
         r=row;
        for(int c=col;c>=0&&r<board.length;c--,r++){
            if(board[r][c]=='Q'){
            return false;}
        }
        return true;
    }
    static void saveBoard(char[][] board,List<List<String>> list){
        String row="";
        List<String> lst=new ArrayList<>();
         for(int i=0;i<board.length;i++){
             row="";
              for(int j=0;j<board[0].length;j++){
                  if(board[j][i]=='Q')
                      row+='Q';
                  else
                  row+='.';
              }
              lst.add(row);
         }
    list.add(lst);
    }
}
    