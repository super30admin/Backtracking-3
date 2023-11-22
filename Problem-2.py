from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def dfs(r, c, index):
            if index == len(word):
                return True

            if r < 0 or r >= rMax or c < 0 or c >= cMax:
                return False
            if board[r][c] != word[index]:
                return False

            temp = board[r][c]
            board[r][c] = "#"

            for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                if dfs(r + dr, c + dc, index + 1):
                    return True

            board[r][c] = temp
            return False

        rMax, cMax = len(board), len(board[0])

        for i in range(rMax):
            for j in range(cMax):
                if board[i][j] == word[0] and dfs(i, j, 0):
                    return True

        return False
