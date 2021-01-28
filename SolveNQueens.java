// Time Complexity : The time complexity is O(m*n) where m is the number of rows and n is the number of columns
// Space Complexity : The space complexity is O(m+n) where m is the number of rows and n is the number of columns
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {

    Set<Integer> column;
    Set<Integer> diagonal1;
    Set<Integer> diagonal2;
    List<List<String>> output;

    public List<List<String>> solveNQueens(int n) {

        column = new HashSet<>();
        diagonal1 = new HashSet<>();
        diagonal2 = new HashSet<>();
        output = new ArrayList<>();

        if(n == 0){
            return output;
        }
        backTrack(n,0,new ArrayList<>());
        return output;

    }

    public void backTrack(int n,int row,List<Integer> list){

        //base case
        if(row == n){
            addInResult(n,list);
            return;
        }

        for(int i=0;i<n;i++){

            // If cell is not in attack, place the queen
            if(!isUnderAttack(row,i)){
                list.add(i);
                column.add(i);
                diagonal1.add(row+i);
                diagonal2.add(row-i);
                backTrack(n,row+1,list);
                column.remove(i);
                diagonal1.remove(row+i);
                diagonal2.remove(row-i);
                list.remove(list.size()-1);
            }
        }
    }

    // check if the queen is in attack
    public boolean isUnderAttack(int i,int j){

        int inDiagonal1 = i+j;
        int inDiagonal2 = i-j;

        if(column.contains(j) || diagonal1.contains(inDiagonal1) || diagonal2.contains(inDiagonal2)){
            return true;
        }
        else{
            return false;
        }
    }

    // add the result
    public void addInResult(int n,List<Integer> list){

        List<String> sub = new ArrayList<>();

        for(int i=0;i<n;i++){

            StringBuilder sb = new StringBuilder();

            for(int j=0;j<n;j++){

                if(j == list.get(i)){
                    sb.append('Q');
                }
                else{
                    sb.append('.');
                }
            }

            sub.add(sb.toString());
        }

        output.add(sub);

    }

}