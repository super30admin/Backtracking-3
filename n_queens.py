# Time Complexity : n!
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : -

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.cols = [0 for _ in range(n)]
        self.hill = [0 for _ in range(2*n - 1)]
        self.dale = [0 for _ in range(2*n - 1)]
        self.queens = set()
        self.output = []
        self.backtrack(0, n)
        return self.output
    
    
    def valid_add(self, row, col):
        return not (self.cols[col] or self.hill[row+col] or self.dale[row-col])
    
    def place_queen(self, row, col):
        self.cols[col] = 1
        self.hill[row+col] = 1
        self.dale[row-col] = 1
        self.queens.add((row,col))
        
    def remove_queen(self, row, col):
        self.cols[col] = 0
        self.hill[row+col] = 0
        self.dale[row-col] = 0
        self.queens.remove((row,col))
        
    def add_solution(self, n):
        solution = []
        for row, col in sorted(self.queens):
            solution.append('.' * col + 'Q' + '.' * (n - col - 1))
        self.output.append(solution)
    
    def backtrack(self, row, n):
        for col in range(n):
            if self.valid_add(row, col):
                self.place_queen(row,col)
                if row + 1 == n:
                    self.add_solution(n)
                else:
                    self.backtrack(row+1, n)
                self.remove_queen(row, col)