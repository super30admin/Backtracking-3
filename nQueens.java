    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/n-queens/
    Time Complexity for operators : o(n!) .. n is guven input (n*(n-3)*(n-6)*...)
    Extra Space Complexity for operators : o(n*n) for newly created matrix.
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. Backtracking
                    A) First fill the matrix with the dots '.' as this is the requirement.
                    B) Then call the backtracking function by passing matrix, index as 0 and n;
                    C) In backtracking, the base condition will be if no queen lefts. then add it to the output and return
                    D) The for loop which acts as a column traversal, first check whether that queen which we are
                       planning to place isSafe or not. 
                       isSafe() - this function will check upper column, left diagonal and right diagonal and if it consists
                       'Q' in it then return false at the end return true;
                    E) if it is safe then put 'Q' in the matrix and  again do the backtracking again on the next row.
                    F) after backtracking if it is not possible to place 'Q' queen then replceit with '.'
                    G) at the base condition, just make output in required format at return it.
    */  

class nQueens {
    public List<List<String>> solveNQueens(int n) {
        
        char matrix[][] = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = '.';        
            }
        }
        
        backtracking(matrix,0,n);
        return answer;
    }
    
    List<List<String>> answer = new ArrayList<>();
    
    private void backtracking(char[][] matrix,int index,int queensLeft){
        // base
        if(queensLeft<=0){
            //add to answer
            answer.add(makeOutput(matrix));
            return;
        }
        
        // for loop backtracking
        for(int i=0;i<matrix.length;i++){
            
            if(isSafe(matrix,index,i)){
                matrix[index][i] = 'Q';
                backtracking(matrix,index+1,queensLeft-1);
                matrix[index][i] = '.';
            }
        }
    }
    
    private List<String> makeOutput(char[][] matrix){
        List<String> returnList = new ArrayList<>();
        
        for(int i=0;i<matrix.length;i++){
            String temp = "";
            for(int j=0;j<matrix[0].length;j++){
                temp += matrix[i][j];
            }
            
            returnList.add(temp);
        }
        
        return returnList;
    }
    
    private boolean isSafe(char[][] matrix,int i,int j){
        int r = i;
        int c = j;
        
        // upper column
        while(r>=0){
            if(matrix[r][c]=='Q')
                return false;
            
            r -= 1;
        }
        
        r = i;
        c = j;
        //left diagonal
        while(r>=0&&c>=0){
            if(matrix[r][c]=='Q')
                return false;
            
            r -= 1; 
            c -= 1; 
        }
        
        r = i;
        c = j;
        //right diagonal
        while(r>=0 && c<matrix.length){
            if(matrix[r][c]=='Q')
                return false;
            
            r -= 1; 
            c += 1;   
        }
        
        return true;
    }
}