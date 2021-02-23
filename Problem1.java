//Time complexity - O()
//Space complexity - O()
//Ran on leetcode-No
//Solution with comments:I came up with logic but could not code it out.
class Solution {
    List<List<String>> output= new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
       if(n==2 || n==3) 
           return output;
       
            backtrack(0,n, new ArrayList<>());
        return output;
    }
    
    public void backtrack(int index, int n, List<String>){
        if(index>=n-1)
        {
            output.add(new ArrayList<>(list));
            return;
        }
       for(int i=0;i<n-1;i++){
           path.add("Q");
           for(int j=0;j<n-1;j++){
               
           }
       }
    }
}