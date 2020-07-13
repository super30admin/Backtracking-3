# Time Complexity : Add - O(n!)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. for each row starting row 0 for check each column if the queen can be placed or not.If it can be
2. We recursively go to next row and again check each column.
3. If we don't find a spot to place a queen in a particular row, we backtrack and re-explore other positions

'''

class Solution:
    
    result = []
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.result = []
        if n == 0:
            return self.result
        
        matrix = [['.' for j in range(n)] for i in range(n)]
        self._backtrack(matrix, 0, n)
        
        return self.result
        
        
    def _backtrack(self, matrix, row, n):
        
        if row == n:
            new_matrix = [None]*n
            for j in range(n):
                new_matrix[j] = "".join(matrix[j])
            
            self.result.append(new_matrix)
            return
        
        for i in range(0, n):
            
            if self.isCorrect(matrix, row, i):
                
                matrix[row][i] = 'Q'
                
                self._backtrack(matrix, row+1,n)
                                
                matrix[row][i] = '.'
                
                
    def isCorrect(self, matrix, r, c): 
        
        #upper left diagonal
        i,j = r,c
        while i >=0 and j >= 0:
            i -= 1
            j -= 1
            
            if i >=0 and j >= 0 and matrix[i][j] == 'Q':
                return False
            
        i,j = r,c
        while i >=0 and j < len(matrix[0]):
            i -= 1
            j += 1
            
            if i >=0 and j < len(matrix[0]) and matrix[i][j] == 'Q':
                return False       
            
        #upper column
        i = r
        while i>=0:
            i -= 1
            if i >=0 and  matrix[i][c] == 'Q':
                return False
            
        return True
            
        
        
                
        
        