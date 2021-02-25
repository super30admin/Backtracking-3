// Time Complexity : O(n!)
// Space Complexity : O(n*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.output=[]
        if n==0:
            return self.output
        board=[['.' for i in range(n)]for j in range(n)]
        self.backtracking(board,0,n)
        return self.output
    
    def backtracking(self,board, i, n): //recursive function which will place one  queen in each row
        if n==0:    //if number of queens ==0 => append the board in output list
            self.output.append(self.makeOutput(board))
            return 
        else:       //otherwise traverse each row to find the valid place to keep queen
            for j in range(len(board[0])):
                if self.isValid(board,i,j):
                    board[i][j]='Q'
                    self.backtracking(board,i+1,n-1)
                    board[i][j]='.'
                
    def isValid(self,board,i,j):    //return true if we can place the queen at current index else return false
        #Upper coloumn
        r=i
        c=j
        while r>=0:
            if board[r][c]=='Q':
                return False
            r-=1
        
        #left diagonal
        r=i
        c=j
        while r>=0 and c>=0:
            if board[r][c]=='Q':
                return False
            r-=1
            c-=1
            
        #right diagonal
        r=i
        c=j
        while r>=0 and c<len(board):
            if board[r][c]=='Q':
                return False
            r-=1
            c+=1
        return True
            
    def makeOutput(self,board):     //create a single list of board and returns
        temp=[]
        for i in range(len(board)):
            st=''
            for j in range(len(board[0])):
                st+=board[i][j]
            temp.append(st)
        return temp
        
#O(n!)
