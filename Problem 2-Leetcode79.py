#Time Complexity: O(m*n*3^L) where m is the number of rows, n is the number of columns and L is the length of the word.
#Space Complexity: O(L) where L is the length of the word.

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        self.dirs = [[-1,0],[1,0],[0,1],[0,-1]]
        self.m = len(board)
        self.n = len(board[0])
        self.freq = [0] * 128

        for i in range(self.m):
            for j in range(self.n):
                c = board[i][j]
                self.freq[ord(c)] += 1

        for c in word:
            self.freq[ord(c)] -= 1
            if self.freq[ord(c)] < 0: return False

        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board, i, j, word, 0):
                    return True

        return False

    def dfs(self, board, i, j, word, idx):
        if idx == len(word): return True

        if i < 0 or j < 0 or i == self.m or j == self.n or board[i][j] == '#':
            return False

        if board[i][j] != word[idx]: return False

        # action
        board[i][j] = '#'
        # recurse
        for dir in self.dirs:
            r = dir[0] + i
            c = dir[1] + j
            if self.dfs(board, r, c, word, idx + 1): return True
        # backtrack
        board[i][j] = word[idx]

        return False

        