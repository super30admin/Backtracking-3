# TC: O(N!)
# SC: O(N^2)
# LeetCode: Y(https://leetcode.com/problems/n-queens/)
# Approach: Start by placing queens in current row, then move to next row and so on
#           if the algorithm is able to place n queens then add the current configuration to the result
#           backtrack when a configuration is not possible to move to next configuration

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.result = []
        
        if not n:
            return self.result
        
        self.board = [[0 for _ in range(n)] for _ in range(n)]
        
        self.backtrack(0, n)
        
        return self.result
        
    def backtrack(self, currentRow, n):
        
        # matching configuration found
        if currentRow == n:
            temp = []
            
            for i in range(n):
                
                tempRow = []
                
                for j in range(n):
                    if self.board[i][j] == 1:
                        tempRow.append("Q")
                    else:
                        tempRow.append(".")
                        
                temp.append("".join(tempRow))
                
            self.result.append(temp)
            
            return
        
        # loop through cols in currentRow    
        for currentCol in range(n):
            # check if currentRow, currentCol is a valid position
            if self.isMoveSafe(currentRow, currentCol, n):
                # place the queen at currentRow, currentCol: action
                self.board[currentRow][currentCol] = 1
                # move to the next row : recurse
                self.backtrack(currentRow + 1, n)
                # move to the next col in current row: backtrack 
                self.board[currentRow][currentCol] = 0
                
    def isMoveSafe(self, currentRow, currentCol, n):
        
        # check column
        for i in range(currentRow, -1, -1):
            if self.board[i][currentCol] == 1:
                return False
            
        # upper left diagonal
        i, j = currentRow, currentCol
        
        while i >= 0 and j >= 0:
            if self.board[i][j] == 1:
                return False
            i -= 1
            j -= 1
            
        # upper right diagonal
        i, j = currentRow, currentCol
        while i >= 0 and j < n:
            if self.board[i][j] == 1:
                return False
            
            i -= 1
            j += 1
            
        return True
        
