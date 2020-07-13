# Time Complexity : O(n*m * 3^l), where n, m are board dimensions, l is the length of the word.
# Space Complexity : O(n*m), recursive stack space
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

# Your code here along with comments explaining your approach

# This is a backtracking approach combined with DFS
# The word given is followed letter by letter and a valid path is found.
class Solution(object):
    def __init__(self):
        self.n = 0
        self.m = 0
        self.dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    def exist(self, board, word):
        self.n, self.m = len(board), len(board[0])

        for i in range(self.n):
            for j in range(self.m):
                if self.backtrack(i, j, board, word, 0):
                    return True

        return False

    def backtrack(self, r, c, board, word, idx):
        # base
        if idx == len(word):
            return True
        if r < 0 or c < 0 or r >= self.n or c >= self.m or board[r][c] == '#':
            return False
        # logic
        if word[idx] == board[r][c]:
            # action
            temp = board[r][c]
            board[r][c] = '#'
            # recurse
            for dir in self.dirs:
                i = r + dir[0]
                j = c + dir[1]
                if self.backtrack(i, j, board, word, idx + 1):
                    return True
            # backtrack
            board[r][c] = temp

        return False
