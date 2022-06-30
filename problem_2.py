# Time Complexity : O(m*n*(3^L)) --> exponential.
# Space Complexity : O(1); recursive stack space - O(L) --> L = length of the word
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def helper(self, board, word, i, j, index, m, n):
        # base
        if index == len(word):
            return True
        if i < 0 or j < 0 or i == m or j == n or board[i][j] == '#':
            return False
        # logic
        if board[i][j] == word[index]:
            board[i][j] = '#'
            for x in self.dirs:
                nr = x[0] + i
                nc = x[1] + j
                if self.helper(board, word, nr, nc, index + 1, m, n):
                    return True
            board[i][j] = word[index]
        return False

    def exist(self, board: list[list[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])
        self.dirs = [[0, -1], [-1, 0], [1, 0], [0, 1]]
        for i in range(m):
            for j in range(n):
                if board[i][j] == word[0]:
                    if self.helper(board, word, i, j, 0, m, n):
                        return True
        return False


print(Solution().exist([["A", "B", "C", "E"], ["S", "F", "C", "S"], ["A", "D", "E", "E"]], 'SEE'))
