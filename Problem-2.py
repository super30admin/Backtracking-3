# Time Complexity : O(M * N * 4^L)  # MxN = board size, L = length of word
# Space Complexity : O(L)           # recursion stack for DFS
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# The code searches for a word in a 2D grid by starting DFS from every cell.
# Each DFS explores neighboring cells recursively while marking visited cells temporarily.
# If the word is fully matched, it returns True; otherwise it backtracks and continues.

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        n = len(board)
        m = len(board[0])

        def dfs(r, c, idx):
            if idx == len(word):
                return True
            if r < 0 or r >= n or c < 0 or c >= m or board[r][c] != word[idx]:
                return False
            
            temp = board[r][c]
            board[r][c] = "#"  # mark visited
            found = (dfs(r+1, c, idx+1) or
                     dfs(r-1, c, idx+1) or
                     dfs(r, c+1, idx+1) or
                     dfs(r, c-1, idx+1))
            board[r][c] = temp  # unmark
            return found

        for r in range(n):
            for c in range(m):
                if board[r][c] == word[0] and dfs(r, c, 0):
                    return True
        return False