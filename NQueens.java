//approach: brute force :The idea is to place queens one by one in different columns, starting from the leftmost column. 
//When we place a queen in a column, we check for clashes with already placed queens. 
//In the current column, if we find a row for which there is no clash, we mark this row and column as part of the solution. 
//If we do not find such a row due to clashes then we backtrack and return false //complexity is o(n ^n).

//optimal apprach:iterate through col and instead of checking every element from left and right diagonal , use property of diagonal which is for left diagonal
//row-col is constant and for right diagonals row+col is constant. 

//time complexity:o(2^n)
//space complexity o(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
	    private static  List<List<String>> result = new ArrayList<>();
	    private static Set<Integer> colSet = new HashSet<>();  //column positions
	    private static Set<Integer> diagonal1 = new HashSet<>(); //right diagonal
	    private static Set<Integer> diagonal2 = new HashSet<>();//left diagonal
	    
	    public static List<List<String>> solveNQueen(int n) {
	        
	        backtracking(n, new ArrayList<String>(),0);
	        return result;
	    }
	    
	    public static void backtracking(int n , List<String> list, int row){
	        if(row == n){
	            result.add(new ArrayList<String>(list));
	            return;
	        }
	        for(int col =0; col<n;col++){
	            if(colSet.contains(col)|| diagonal1.contains(row+col) || diagonal2.contains(row -col)){
	                continue;
	            }
	            char[] charArray = new char[n];
	            Arrays.fill(charArray, '.');
	            charArray[col] ='Q';
	            String rowString = new String(charArray);
	            
	            list.add(rowString);            
	            colSet.add(col);
	            diagonal1.add(row+col);
	            diagonal2.add(row-col);
	            
	            backtracking(n,list,row+1);  //recursive call for current column col check which next row is safe for queen.
	            //if no next row is safe then backtrack and change col to next position (for loop executes and got to next col)
	            
	            list.remove(list.size()-1);
	            colSet.remove(col);
	            diagonal1.remove(row+col);
	            diagonal2.remove(row-col);
	        }
	        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =4;
		List<List<String>> output = new ArrayList<>();
       output= solveNQueen(n) ;
       
        System.out.println(output.size()); 
        if(output.size()==0) System.out.print("cant place n queens");
        for (int i = 0; i < output.size(); i++) { 
      
            System.out.println(output.get(i)); 
        } 

        
	}

}
