# Time Complexity : O(m*n*4^L)
# Space Complexity : O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        def backtrack(i, j, k):
            if k == len(word):
                return True
            if i < 0 or i >= m or j < 0 or j >= n or board[i][j] != word[k]:
                return False
            tmp, board[i][j] = board[i][j], '#'
            found = (
                backtrack(i+1, j, k+1) or
                backtrack(i-1, j, k+1) or
                backtrack(i, j+1, k+1) or
                backtrack(i, j-1, k+1)
            )
            board[i][j] = tmp
            return found
        for i in range(m):
            for j in range(n):
                if backtrack(i, j, 0):
                    return True
        return False
        