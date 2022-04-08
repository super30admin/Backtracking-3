import java.util.ArrayList;
import java.util.List;

//Time Complexity: Exponential O(n!)
//Space Complexity: O(n^n) 
public class NQueens {	
	/**Approach: DFS+Backtrack**/
	List<List<String>> res;
    boolean[][] board;
    int m;
    public List<List<String>> solveNQueens(int n) {
        res= new ArrayList<>();
        if(n==0) return res;
        m=n;
        board= new boolean[n][n];
        helper(0);
        return res;
    }
    private void helper(int r){
        //base
        if(r==m){
            List<String> list= new ArrayList<>();
            for(int i=0; i<m; i++){
                StringBuilder sb= new StringBuilder();
                for(int j=0; j<m; j++){                    
                    if(board[i][j]){
                        sb.append('Q');
                    }else {
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
        }
        
        //helper
        for(int j=0; j<m; j++){  
            if(isSafe(r,j)){                
                board[r][j]=true; //action                
                helper(r+1); //recurse                
                board[r][j]=false; //backtrack
            }
        }
    }
    private boolean isSafe(int r, int c){
        //up
        for(int i=0; i<r; i++){
            if(board[i][c]) return false;
        }
        //diagonal up right
        int i=r; int j=c;
        while(i>=0 && j<m){
            if(board[i][j]) return false;
            i--;j++;
        }
        //diagonal up left
        i=r; j=c;
        while(i>=0 && j>=0){
            if(board[i][j]) return false;
            i--;j--;
        }
        return true;
    }
	
	// Driver code to test above 
	public static void main (String[] args) {
		NQueens ob = new NQueens();
    	int n=4;     	
    	
		System.out.println("N-Queens placement for "+n+"X"+n+" board: "+ob.solveNQueens(n));
	}
}
