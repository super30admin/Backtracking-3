//Time complexity - O(n!)
//Space complexity - O(n)
//Ran on leetcode-yes
//Solution with comments:
class Solution {
    List<List<String>> output= new ArrayList<>();
    //char[][] board;
    int[] queen;
    int len;
    HashSet<Integer> col;
    HashSet<Integer> left_diag;
    HashSet<Integer> right_diag;
    public List<List<String>> solveNQueens(int n) {
        //board= new char[n][n];
        len=n;
        queen= new int[n];
        col= new HashSet<>();
        left_diag= new HashSet<>();
        right_diag= new HashSet<>();
        backtrack(n,0);
        return output;
    }
    
    public void backtrack(int n, int i){
        if(n==0){
            outputformat();
            return;
        }
       
        for(int j=0;j<len;j++){
            
            if(isValid(i,j)){
                
                //board[i][j]='Q';
                queen[i]=j;
                backtrack(n-1,i+1);
                queen[i]=0;
                //board[i][j]='.';
                col.remove(j);
                left_diag.remove(i-j);
                right_diag.remove(i+j);
                }
        }
        
    }
    
    public boolean isValid(int i, int j){
        if(col.contains(j) || left_diag.contains(i-j) || right_diag.contains(i+j) )
            return false;
        col.add(j);
        left_diag.add(i-j);
        right_diag.add(i+j);
        
        return true;
        
         
    }
    public void outputformat(){
        StringBuilder str;
        List<String> temp= new ArrayList<>();
            for(int i=0;i<len;i++){
                int col= queen[i];
                str=new StringBuilder();
                    for(int j=0; j<len;j++ )
                    {
                        if(j==col)
                            str.append("Q");
                        else
                            str.append(".");
                    }
                 temp.add(str.toString());
                }
        output.add(new ArrayList<>(temp));
    }
}