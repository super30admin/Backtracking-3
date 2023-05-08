# Time Complexity : O(N * 3^L), where N is the number of cells in the board and L is the length of the word
# Space Complexity : O(L), where L is the length of the word
from typing import List
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def backtrack(row, col, index):
            if index == len(word):
                return True

            if row < 0 or row >= rows or col < 0 or col >= cols or board[row][col] != word[index]:
                return False

            # Mark the current cell as visited
            board[row][col] = "#"

            # Explore the neighboring cells in all four directions
            found = backtrack(row - 1, col, index + 1) \
                    or backtrack(row + 1, col, index + 1) \
                    or backtrack(row, col - 1, index + 1) \
                    or backtrack(row, col + 1, index + 1)

            # Restore the original value of the cell
            board[row][col] = word[index]

            return found

        rows, cols = len(board), len(board[0])

        for row in range(rows):
            for col in range(cols):
                if board[row][col] == word[0] and backtrack(row, col, 0):
                    return True

        return False