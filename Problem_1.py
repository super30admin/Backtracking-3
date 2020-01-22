# Runs on Leetcode
    # Runtime - O(n^n)

class Solution:
    def isSafe(self, position, queen_position):
        for queen in queen_position:
            if position[0] == queen[0] or position[1] == queen[1] or (abs(queen[0]-                                     position[0])==abs(queen[1]-position[1])):
                return False
        return True
        
    def helper(self,n , queen_positions, j):
        if j == n:
            self.temp.append(list(queen_positions))
        for i in range(n):
            if self.isSafe((i, j), queen_positions):
                queen_positions.add((i, j))  
                self.helper(n, queen_positions, j + 1)   
                queen_positions.remove((i, j)) 
    
    def solveNQueens(self, n: int) -> List[List[str]]:
        if not n:
            return []
        
        if n == 1:
            return ['Q']
        
        self.temp = []
        final = []
        self.helper(n, set(), 0)
        
        for x in self.temp:
            board = [''] * n
            for i in range(n):
                for j in range(n):
                    if (i,j) not in x:
                        board[i] +=  '.'
                    else:
                        board[i] +=  'Q'
            final.append(board)
        return final
