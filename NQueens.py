# TC: O(N!) since we have (N - 2 ^ k) where k goes from 0 to N and N is the input given to us or the number of rows. 
# SC: O(N x N) to store the board state: matrix of size N x N.

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board = [[0]*n for _ in range(n)]
        self.result = []
        
        def isSafe(i, j):
#            check top rows in same column
            for r in range(i):
                if board[r][j] == 1:
                    return False
            
#            check diagonal top right
            r = i
            c = j
            while (r >= 0 and c < n):
                if board[r][c] == 1:
                    return False
                r -= 1
                c += 1 
                
#             check diagonal top left 
            
            r = i
            c = j
            while (r >= 0 and c >= 0):
                if board[r][c] == 1:
                    return False
                r -= 1
                c -= 1
            return True
        
        def backtrack(r):
#             base
            if r == n: 
                # print('h')
                temp_list = []
                for i in range(n):
                    curr_str = ''
                    for j in range(n):
                        if board[i][j] == 1:
                            curr_str += 'Q'
                        else: 
                            curr_str += '.'
                    temp_list.append(curr_str)
                self.result.append(temp_list)         
                return
            
#             logic
            for c in range(n):
                if isSafe(r, c):
#                   action
                    board[r][c] = 1
#                   recurse
                    backtrack(r + 1)
#                   backtrack
                    board[r][c] = 0
        backtrack(0)
        return self.result 
