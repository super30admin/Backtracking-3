"""
Time Complexity : O(3^n)
Space Complexity : O(n) recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
We find the first character here and call our DFS . Simultaneously we change our character to # if we find our
character, if we cannot continue, we backtrack and convert hash to temp
"""


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or not word:
            return False
        char = word[0]
        m = len(board)
        n = len(board[0])
        self.dirs = [(0, 1), (-1, 0), (0, -1), (1, 0)]
        for i in range(m):
            for j in range(n):
                if board[i][j] == char and self.helper(board, i, j, word, 0):
                    return True
        return False

    def helper(self, board, i, j, word, index):
        if index == len(word):
            return True
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] == '#':
            return
        if board[i][j] == word[index]:
            temp = board[i][j]
            board[i][j] = '#'
            for d in self.dirs:
                r = i+d[0]
                c = j+d[1]
                if self.helper(board, r, c, word, index+1):
                    return True
            board[i][j] = temp
