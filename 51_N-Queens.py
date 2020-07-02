# Time Complexity : O(n!)[n = given input]
# Space Complexity : O(n * n)[n = given input]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach(Backtracking)
# 1. Place the queens row- wise. Start with position of first queen as (0,0)
# 2. Find the safe position for the next queen
# 3. If next queen cannot be placed at a safe position, then backtrack and move the previous queen to necx column
# 4. Add the queen to result set if all the queens are placed successfully
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [[0 for j in range(n)] for i in range(n)]
        def isSafe(r,c):
            # column
            for i in range(r):
                if board[i][c] == 1:
                    return False
            
            # diagonal
            i = r-1
            j = c-1
            while i>=0 and j >=0 :
                if board[i][j] == 1:
                    return False
                i-=1
                j-=1
            
            # anti diagonal
            i = r-1
            j = c+1
            while i >= 0 and j < n:
                if board[i][j] == 1:
                    return False
                i-=1
                j+=1
            return True
                
        def backtrack(r):
            nonlocal res, board
            if r == len(board):
                s = []
                # print(board)
                for i in range(n):
                    curr = ''
                    for j in range(n):
                        if board[i][j] == 0:
                            curr += '.'
                        else:
                            curr +=  'Q'
                    s.append(curr)
                res.append(s)
                return
                
            for i in range(0, n):
                if isSafe(r,i):
                    # action
                    board[r][i] = 1
                    # recurse
                    backtrack(r+1)
                    # backtrack
                    board[r][i] = 0
        backtrack(0)
        return res