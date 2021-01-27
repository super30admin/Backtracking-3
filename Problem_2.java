// Time Complexity :O(n) + O(m*n)*O(n)
// Space Complexity :O(1)//no extra memory is used.
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

//I checked the valid possible outcomes by keeping the queens at all the possible places in the first row.
//if a valid solution is achieved then I add it to my result arraylist


class Solution {
    static List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
		for(int i=0;i<board[0].length;i++) {//O(n)
			board=new boolean[n][n];
			board[0][i]=true;
			createPattern(board,0);
			
		}
        return result;
    }
    
	//this thosuld take O(m*n)
    public static boolean createPattern(boolean[][] board,int row) {
		if(row==board.length-1) {
            List<String> list=new ArrayList<>();
			for(int i=0;i<board.length;i++){
                StringBuilder str=new StringBuilder();
                for(int j=0;j<board[i].length;j++){
                    if(board[i][j]){
                        str.append("Q");
                    }else{
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }
            result.add(list);
			//System.out.println("----");
			return true;
		}
		for(int col=0;col<board[0].length;col++) {
			int rowNew=row+1;
			if(validate(board,rowNew,col)) {
				board[rowNew][col]=true;
				// if(createPattern(board,rowNew)) {
				// 	return true;
				// }
                createPattern(board,rowNew);
				board[rowNew][col]=false;
			}
		}
		
		return false;
	}
	
	//the dominating part here will be whne we compare the diaogonal validity O(sqrt(m^2+O^2)) //O(n)
	public static boolean validate(boolean[][] board,int row,int col) {
		//validating the same column
		for(int i=row;i>=0;i--) {
			if(board[i][col]) {
				return false;
			}
		}
		
		//validating the top left
		for(int i=row,j=col;i>=0 && j>=0;i--,j--) {
			if(board[i][j]) {
				return false;
			}
		}
		
		//validating the top right
		for(int i=row,j=col;i>=0 && j<board[0].length;i--,j++) {
			if(board[i][j]) {
				return false;
			}
		}
		
		return true;
		
	}
}