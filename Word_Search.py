'''
Time Complexity - O(n*3^L) where L is length of words
Space Complexity - O(L)
'''


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board == None or len(board) == 0:
            return False
        m = len(board)
        n = len(board[0])
        self.dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        for i in range(m):
            for j in range(n):
                if word[0] == board[i][j]:
                    if self.helper(board, i, j, word, 0) == True:
                        return True
        return False

    def helper(self, board, i, j, word, index):

        if index == len(word):
            return True
        if i < 0 or j < 0 or i >= len(board) or j >= len(board[0]) or board[i][j] == '#':
            return False

        if board[i][j] == word[index]:
            board[i][j] = '#'
            for d in self.dirs:
                nr = i + d[0]
                nc = j + d[1]
                if self.helper(board, nr, nc, word, index+1) == True:
                    return True
            board[i][j] = word[index]
