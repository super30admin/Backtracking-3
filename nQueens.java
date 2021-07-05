//Time Complexity:O(N^2*N!)
//Space Complexity:O(N^2)
//In this problem, I'll be having a separate class to contain the possible positions of the queens in the board without attacking each other. I'll then go into the backtrack function and check if my current position is equal to the n that is given to me, I'll be creating a string buffer and go through the positions list and append Q in my string buffer at those positions contained by my positions list ,"." for those positions athat are not in the positions list.and then I'll be appending this string buffer to a temporary list. A the end I'll be appending the temp list to my result list and return. If I have reached the end, I'll keep checking the possible safe positions to place my queen in the board. If I cannot find such a position, I'll be returning false. If I have found a position, I'll then move to the next row to find the safe position for the next queen. 
//This code was executed successfully and got accepted in leetcode.

class Solution {
    class Position{
        int row,col;
        Position(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        Position[] pos=new Position[n];
        backtrack(res,pos,0,n);
        return res;
    }
    public void backtrack(List<List<String>> res,Position[] position,int cur, int n){
        if(n==cur){
            StringBuffer s= new StringBuffer();
            List<String> temp=new ArrayList<>();
            for(Position p:position){
                for(int i=0;i<n;i++){
                    if(p.col==i){
                        s.append("Q");
                    }
                    else{
                        s.append(".");
                    }
                }
                temp.add(s.toString());
                s=new StringBuffer();
            }
            res.add(temp);
            return;
        }
        for(int i=0;i<n;i++){
            boolean foundpos=true;
            for(int j=0;j<cur;j++){
                
                if(position[j].col==i||position[j].col-position[j].row==i-cur||position[j].col+position[j].row==i+cur){
                    foundpos=false;
                    break;
                }
            }
            if(foundpos){
                position[cur]=new Position(cur,i);
                backtrack(res,position,cur+1,n);
            }
        }
    }
}