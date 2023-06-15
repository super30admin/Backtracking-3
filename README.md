# Backtracking-3

## Problem1 
N Queens(https://leetcode.com/problems/n-queens/)
##
TC:o(n)
SC:o(n)
##
class Solution:

    def solveNQueens(self, n: int) -> List[List[str]]:

        def dfs(queens, dif, sum):

            p = len(queens)
            
            if p == n:

                result.append(queens)
                
                return None

            for q in range(n):

                if q not in queens and p-q not in dif and p+q not in sum:

                    dfs(queens+[q], dif+[p-q], sum+[p+q])
        result = []

        dfs([],[],[])
        
        return [["."*i + "Q" + "."*(n-i-1) for i in sol] for sol in result]




## Problem2
Word Search(https://leetcode.com/problems/word-search/)
##
TC:o(n)
SC:o(n)
##
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(i, j, k):
            # if k is equal to the length of the word, return True
            if not 0 <= i < len(board) or not 0 <= j < len(board[0]) or board[i][j] != word[k]:
                return False
            if k == len(word) - 1:
                return True
            tmp, board[i][j] = board[i][j], '/'
            res = dfs(i+1, j, k+1) or dfs(i-1, j, k+1) or dfs(i, j+1, k+1) or dfs(i, j-1, k+1)
            board[i][j] = tmp
            return res
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if dfs(i, j, 0):
                    return True
        return False

