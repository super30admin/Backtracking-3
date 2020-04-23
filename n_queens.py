"""
// Time Complexity : O(n*n!)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
Given below
"""
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        """
        1. isSafe function to check if the queen can be placed in left diagonal, along the upper column
        or right diagonal
        2. Forming the output list of board with queens placed
        3. Backtracking function - takes the board, row index, n
            - Iterate over the cols of board length
                - update the board value to 'Q'
                - recurse with n-1 queens
                - reset the value to '.'
        """
        def prepare_output(board):
            result = []
            for i in range(len(board)):
                temp = ""
                for j in range(len(board)):
                    temp+= board[i][j]
                result.append(temp)
            output.append(result)
            #return result
        
        
        def backtrack(board,row,n):
            if n == 0:
                #prepare the output
                prepare_output(board)
                return
            
            for col in range(0,len(board)):
                if isSafe(board,row,col):
                    board[row][col] = 'Q'
                    backtrack(board,row+1,n-1)
                    board[row][col] = '.'
        
        
        def isSafe(board,i,j):
            #check colum
            for k in range(i):
                if board[k][j] == 'Q':
                    return False
            
            #check left diagonal
            x,y = i-1,j-1
            while x >=0 and y >=0:
                if board[x][y] == 'Q':
                    return False
                x-=1
                y-=1
            
            #check right diagonal
            x,y = i-1,j+1
            while x >=0 and y < len(board):
                if board[x][y] == 'Q':
                    return False
                x-=1
                y+=1
            return True
        
        board = [['.' for _ in range(n)]for _ in range(n)]
        output = []
        backtrack(board,0,n)
        return output