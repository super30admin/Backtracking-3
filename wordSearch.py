"""
Problem: Word Search
Approach: start from one of the (i, j) in the board and do dfs to find the word. Do not visit already visited (row, col).
t.c. => O(3^L) since we have 3 options to go to. One of them is already visited. L = len(word)
s.c. => O(L) L is len(word)
"""
class Solution:
    def __init__(self):
        self.i = 0
    def exist(self, board: List[List[str]], word: str) -> bool:
        m, n = len(board), len(board[0])
        wlen = len(word)
        directions = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        visited = set()
        def helper(row, col):
            if self.i == wlen:
                return True

            if row < 0 or col < 0 or row >= m or col >= n or (row, col) in visited or word[self.i] != board[row][col]:
                return False

            visited.add((row, col))
            self.i += 1
            for i, j in directions:
                if helper(i + row, j + col):
                    return True
            self.i -= 1
            visited.remove((row, col))
            return False
        for i in range(m):
            for j in range(n):
                if helper(i, j):
                    return True
        return False