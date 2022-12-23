#N-Queens
# Time Complexity -> O(n!)
# Space Complexity -> O(n^2)
class Solution:
    def add_result(self, board, n):
        ans = []
        for i in range(n):
            arow = []
            for j in range(n):
                if board[i][j]:
                    arow.append('Q')
                else:
                    arow.append('.')
            ans.append(''.join(arow))

        self.res.append(ans)
    def backtrack(self, board, n, col, leftrow, upperdiagonal, lowerdiagonal):
        if col == n:
            self.add_result(board, n)
            return

        for row in range(n):
            if leftrow[row] and lowerdiagonal[row+col] and upperdiagonal[n-1 + col - row]:
                board[row][col] = True
                leftrow[row] = False
                lowerdiagonal[row+col] = False
                upperdiagonal[n-1 + col - row] = False
                
                self.backtrack(board, n, col+1, leftrow, upperdiagonal, lowerdiagonal)
                
                board[row][col] = False
                leftrow[row] = True
                lowerdiagonal[row+col] = True
                upperdiagonal[n-1 + col - row] = True
                
        

    def solveNQueens(self, n: int) -> List[List[str]]:
        self.res = []
        board = [[False]*n for _ in range(n)]
        leftrow = [True]*n
        upperdiagonal = [True]*(2*n - 1)
        lowerdiagonal = [True]*(2*n - 1)

        self.backtrack(board, n, 0, leftrow, upperdiagonal, lowerdiagonal)
        return self.res

'''
Word Search
Time Complexity -> O(3^L) L -> Length of the word
Space Complexity -> O(L) Stack space for recursion 
'''