from typing import List


class Solution:

    def exist(self, board: List[List[str]], word: str) -> bool:
        """
            https://leetcode.com/problems/word-search/
            Time Complexity: O(4^l * (m*n))
                'l' is the length of the string
                'm' number of rows
                'n' number of cols
            Space Complexity: O(m*n + l)
                'l' recursive stack space
                'm*n' visited array
        """
        # A [B,S,D]
        # B [A,F,C]
        # C [B,E,F,S]
        # E [D,C,S,E]
        # S [A,F,E]
        # F [S,D,C]
        # D [A,F,E]
        # E [D,C,E]
        self.rows = len(board)
        if not board or not self.rows or not word:
            return False
        self.cols = len(board[0])
        self.visited = [[False for col in range(self.cols)] for row in range(self.rows)]
        for row in range(self.rows):
            for col in range(self.cols):
                if self._dfs(board, word, row, col):
                    return True
        return False

    def _dfs(self, board: List[List[str]], word: str, row: int, col: int):
        # base case
        if (row < 0 or row >= self.rows) or (col < 0 or col >= self.cols) or self.visited[row][col]:
            return False
        # logic
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        if board[row][col] == word[0]:
            if len(word) == 1:
                print(row, col, word[0])
                return True
            self.visited[row][col] = True
            for dir in dirs:
                r = row + dir[0]
                c = col + dir[1]
                if self._dfs(board, word[1:], r, c):
                    print(row, col, word[0])
                    return True
            # backtrack
            self.visited[row][col] = False
        return False


if __name__ == '__main__':
    h = Solution()
    print(h.exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]],
                  "ABCCED"))
