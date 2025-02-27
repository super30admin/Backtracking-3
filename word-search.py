# Time Complexity : O(m*n)3^L - L is the length of word
# Space Complexity : O(L) - for recursion stack
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
DFS
"""


class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        if not board or not board[0]:
            return False

        m = len(board)
        n = len(board[0])
        self.directions = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        for i in range(0, m):
            for j in range(0, n):
                if word[0] == board[i][j]:
                    if self.helper(board, i, j, word, 0):
                        return True
        return False

    def helper(self, board, i, j, word, index):

        if index == len(word):
            return True

        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] == "#":
            return False

        if word[index] == board[i][j]:
            board[i][j] = "#"
            for dir in self.directions:
                nr = i + dir[0]
                nc = j + dir[1]
                if self.helper(board, nr, nc, word, index + 1):
                    return True

            board[i][j] = word[index]

