# Time Complexity : O(m * n * 4^L), where m = rows, n = cols, and L = length of the word
# Space Complexity : O(L), for recursion stack where L is the word length
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# I used DFS and backtracking to search the word character-by-character.
# For each cell in the grid, if it matched the first letter of the word, I started DFS.
# I used a visited set (in-place marking) to make sure the same cell wasn't reused in the same path.
# I also used pruning to immediately return False when a mismatch occurred, making it faster.

from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        rows, cols = len(board), len(board[0])

        def dfs(r, c, i):
            if i == len(word):
                return True
            if r < 0 or r >= rows or c < 0 or c >= cols:
                return False
            if board[r][c] != word[i]:
                return False

            temp = board[r][c]
            board[r][c] = '#'  # Mark as visited

            found = (dfs(r + 1, c, i + 1) or
                     dfs(r - 1, c, i + 1) or
                     dfs(r, c + 1, i + 1) or
                     dfs(r, c - 1, i + 1))

            board[r][c] = temp  # Backtrack
            return found

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == word[0] and dfs(r, c, 0):
                    return True

        return False
