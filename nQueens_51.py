# Time Complexity : O((N)*(N-3)*(N-6)...) so, approx. = O(N! - C)
# Space Complexity : O(N*M) because we made the matrix, but stack-> O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
#Approach and intuition:
#0. each row needs to fit atleast one queen[ N queens on N*N board ], so we start placing queens in first cell of first row and then move to next row to find valid queen positions. If we can't find a valid spot in a row, backtrack and check the next valid row value for the queen in previous row.
#1. check row, col and diagonal for valid positions
#2. check position of other queens
#3. How to validate a position? we need to check only for 3 cells(dirns: up, upper left diagonal, upper right diagonal) as we have placed valid queens till row-1!
#4. Initiate matrix with "."s
#5. When you want to insert a queen, replace "." with "Q" and vice cersa to remove it after backtracing
#6. do o/p modification once a valid solution exists

class Solution:
    
    def __init__(self):
        self.output = []
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        board = [[" " for _ in range(n)] for _ in range(n)]
        
        for i in range(n):
            for j in range(n):
                board[i][j] = '.'
                
        self.backtracking(board, n, 0)
        return self.output
                
        
    def backtracking(self, board, queensLeft, i):
        
        #base case
        if queensLeft <= 0:
            self.output.append(self.makeOutput(board))
            return
        
        #place queen, make recursive calls
        for j in range(len(board)):
            if(self.isValid(board, i, j)):
                board[i][j] = 'Q'
                self.backtracking(board, queensLeft-1, i+1)
                board[i][j] = '.'
                
    def makeOutput(self, board):
        nQList = []
        
        for i in range(len(board)):
            temp = ""
            for j in range(len(board)):
                temp += board[i][j]
                
            nQList.append(temp)
            
        return nQList
    
    def isValid(self, board, i, j):
        row = i
        col = j
        
        #upper column
        while row>=0:
            if board[row][col] == 'Q':
                return False
            row -= 1
            
        #left diagonal
        row = i
        col = j
        while row>=0 and col >= 0:
            if board[row][col]=='Q':
                return False
            row -= 1
            col -= 1
            
        #right diagonal
        row = i
        col = j
        while row>=0 and col < len(board):
            if board[row][col]=='Q':
                return False
            row -= 1
            col += 1
            
        return True
            
    
        
        