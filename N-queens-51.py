

# Time Complexity : O(n*m!)
# Space Complexity : O(n)  
# Did this code successfully run on Leetcode : No (There's some problem with LC. The below code is running well when I am having n = 1 but giving an error while submitting)
# Any problem you faced while coding this : No

class Solution(object):
    
    right_diagonal = set()
    left_diagonal = set()
    col = set()
    output = []
    
    def isValid(self, board, c, r):
        #check whether positon is alredy occupied
        if c not in self.col and r - c not in self.left_diagonal and r + c not in self.right_diagonal:
            return True
        return False
    
    def backtrack(self, board, queensLeft, row):
        if queensLeft == 0:
            self.output.append(self.makeBoard(board))
            
        for c in range(len(board)):
            #check for valid position
            if self.isValid(board, c, row):
                #backtracking
                board[row][c] = "Q"
                self.right_diagonal.add(row+c)
                self.left_diagonal.add(row-c)
                self.col.add(c)
                
                self.backtrack(board, queensLeft - 1, row + 1)
                
                board[row][c] = "."
                self.right_diagonal.remove(row+c)
                self.left_diagonal.remove(row-c)
                self.col.remove(c)
    
    def makeBoard(self, board):
        res = []
        for i in range(len(board)):
            temp = ''
            for j in range(len(board[0])):
                temp += board[i][j]
            res.append(temp)
        return res
        
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        board = [['.' for _ in range(n)] for _ in range(n)]
        
        self.backtrack(board, n, 0)
        
        return self.output
