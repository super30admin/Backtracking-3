class Solution:
    
    """
    Description: Find all distinct solutions to n-queens puzzle (place quees on n x n chessboard such that no two queens attack each other)
    
    Solution worked in Leetcode: 
    
    Time Complexicity: O(N!)
    Space Complexicity: O(n*n) {from actual O(n*n + n)}
    
    Approach: Use backtrackking:
    1. define an empty chessboard as list of list with size n x n
    2. place first queen at (0, 0) followed by (0, 1) ... (same row) recursively
    3. check positions of next queen in next row and place where it is safe to do so (replace value from 0 to 1)
    4. recurse and backtrack if solution has conflict
    5. repeat with new starting position for the queen (#2)
    6. Once solution is found append to resulting list by replacing 1 with "Q" and 0 with "." (instructions)
    """
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        self.n = n # global
        self.result = []
        self.chessboard = [[0 for i in range(self.n)] for i in range(self.n)]
        
        if n == None or n == 0: return self.result
        self.backtrack(0)
        
        return self.result
        
    def backtrack(self, row):
        
        # Base
        if row == self.n:
            self.result.append(self.Qboard(self.chessboard))
            
        # Logic
        for col in range(self.n):
            if self.safeMove(row, col):
                # action:
                self.chessboard[row][col] = 1
                
                # recurse
                self.backtrack(row + 1)
                
                # backtrack
                self.chessboard[row][col] = 0
                
    def Qboard(self, board):
        return ["".join(["Q" if i == 1 else "." for i in item]) for item in board]
                
    def safeMove(self, row, col):
        
        # check column
        for i in reversed(range(row)):
            if self.chessboard[i][col] == 1: return False
        
        # check left diagonal
        i = row; j = col
        while i >=0 and j >= 0:
            if self.chessboard[i][j] == 1: return False
            i -= 1; j -= 1
        
        # check right diagonal
        i = row; j = col
        while i >=0 and j < self.n:
            if self.chessboard[i][j] == 1: return False
            i -= 1; j += 1
        
        return True
