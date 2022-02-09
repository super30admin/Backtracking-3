'''
TC: O(n!) = (n * n - 2/3 * n - 4/6 .....) 
SC: O(n*n)
'''
class Solution:
    def __init__(self):
        self.board = None
        self.res = list()
    
    def isSafe(self, r, c, n):
        if r >= 0 and c >= 0 and r < n and c < n:
            tempr, tempc = r, c
            
            while tempr >= 0 and tempc >= 0:
                if self.board[tempr][tempc] == "Q":
                    return False
                tempr -= 1
                tempc -= 1
            tempr, tempc = r, c
            
            while tempr >= 0 and tempc < n:
                if self.board[tempr][tempc] == "Q":
                    return False
                tempr -= 1
                tempc += 1
            tempr, tempc = r, c
            
            while tempr >= 0:
                if self.board[tempr][tempc] == "Q":
                    return False
                tempr -= 1
            
            return True
        
        return False
            
    def helper(self, row, n):
        if row >= n:
            self.res.append(["".join(self.board[i]) for i in range(n)])
            return 
        
        for j in range(n):
            if self.isSafe(row, j, n):
                self.board[row][j] = "Q"
                self.helper(row + 1, n)
                self.board[row][j] = "."

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board = [["." for i in range(n)] for j in range(n)]
        self.helper(0, n)
        return self.res