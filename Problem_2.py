"""
## Problem2
Word Search(https://leetcode.com/problems/word-search/)
"""
from typing import List

class Solution:
    """
    TC : O(m * n)
    SC: O(1)
    """
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

        def dfs(row, col, index):
            # Base case: entire word matched
            if index == len(word):
                return True

            # Boundary and character check
            if row < 0 or row >= m or col < 0 or col >= n or board[row][col] != word[index]:
                return False

            # Mark current cell as visited by temporary replacement
            temp = board[row][col]
            board[row][col] = '#'  # any non-alphabet character to mark visited

            for dr, dc in directions:
                if dfs(row + dr, col + dc, index + 1):
                    return True

            board[row][col] = temp  # backtrack
            return False

        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0] and dfs(i, j, 0):
                    return True

        return False
