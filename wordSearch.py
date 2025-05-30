from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])

        def dfs(r, c, i):
            # If we matched the entire word
            if i == len(word):
                return True

            # If out of bounds or wrong char
            if r < 0 or c < 0 or r >= ROWS or c >= COLS or board[r][c] != word[i]:
                return False

            # Temporarily mark the cell as visited
            temp = board[r][c]
            board[r][c] = "#"

            # Explore all 4 directions
            res = (
                dfs(r + 1, c, i + 1)
                or dfs(r - 1, c, i + 1)
                or dfs(r, c + 1, i + 1)
                or dfs(r, c - 1, i + 1)
            )

            # Restore the cell back
            board[r][c] = temp
            return res

        for r in range(ROWS):
            for c in range(COLS):
                if dfs(r, c, 0):
                    return True
        return False


board = [["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]]
word = "ABCCED"

solution = Solution()
print(solution.exist(board, word))  # Output: True
