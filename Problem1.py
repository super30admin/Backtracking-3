## Problem1 
#N Queens(https://leetcode.com/problems/n-queens/)

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def isvalid(col,slate):
            for earlierq in range(len(slate)):
                if slate[earlierq] == col:
                    return False
                rowdiff = abs(len(slate) - earlierq)
                coldiff = abs(col-slate[earlierq])
                if rowdiff == coldiff:
                    return False
            return True
        def helper(row,slate):
            if row == n:
                result.append(slate[:])
                return
            for col in range(n):
                if isvalid(col,slate):
                    slate.append(col)
                    helper(row+1,slate)
                    slate.pop()
                    
        result = []
        helper(0,[])
        final_result = []
        for item in result:
            board = [["."]*n for _ in range(n)]
            for row,col in enumerate(item):
                board[row][col] = "Q"
            final_result.append(["".join(x) for x in board])
        return final_result
    #approach: dfs

