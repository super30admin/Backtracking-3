'''
## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)

TC =  O(N!)
Sc =   O(N²) (mainly because of the board and storing results)
Approach = Backtracking
'''

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col = set()
        posDaig = set()
        negDaig = set()
        result = []
        board = [["."] * n for _ in range(n) ]

        def backTrack(r):
            if r == n:
                copy = ["".join(r) for r in board]
                result.append(copy)
                return

            for c in range(n):
                if c in col or (r+c) in posDaig or (r-c) in negDaig:
                    continue
                
                col.add(c)
                posDaig.add(r+c)
                negDaig.add(r-c)
                board[r][c] = "Q"

                backTrack(r+1)

                col.remove(c)
                posDaig.remove(r+c)
                negDaig.remove(r-c)
                board[r][c] = "."
                
        backTrack(0)
        return result






        