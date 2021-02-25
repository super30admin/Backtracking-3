// Time Complexity : O(n*m * 3^k) k= word length
// Space Complexity : O(n*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or len(board)==0 or not board[0] or len(board[0])==0:
            return False
        
        self.dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        
        for i in range(len(board)):
            for j in range(len(board[0])):      #traverse the board and whenever we find the first letter of word in the board we call a backtracing function
                if board[i][j]==word[0]:
                    if self.backtracking(board,i,j,word,0): //if the function returns true then simply return True else try to search the first letter in the board
                        return True 
        return False
        
        
    def backtracking(self,board,i,j,word,index):
        if index==len(word)-1:      //if the index is pointing to the last element of the the word =>return true as we got all the letters of word in a board
            return True
        
        temp=board[i][j]        //store the current letter of the board in the temp
        board[i][j]='#'         //replace the letter in the board with  #
        
        for dir in self.dirs:       // find the letters in all the four directions aroud the current index
            r=i+dir[0]
            c=j+dir[1]
            
            if r>=0 and r < len(board) and c>=0 and c<len(board[0]) and board[r][c]==word[index+1]: //if any letter is same as the next letter of word then again call backtracing on that index
                if self.backtracking(board,r,c,word,index+1):
                        return True
        
        board[i][j]=temp    //after returning from backtracing function change the value of board with the temp value
        return False
        
        
        
