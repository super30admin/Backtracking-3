# Accepted on leetcode(79)
# time - O()
# Using DFS approach
class Solution:
    def exist(self, board, word: str) -> bool:
        # Edge case
        if not board: return False
        if not word: return True
        m = len(board)
        n = len(board[0])
        for i in range(m):
            for j in range(n):
                if self.exist_word(board, word, i, j):
                    return True
        return False

    def exist_word(self, board, word, i, j):
        # base case
        if board[i][j] == word[0]:
            if not word[1:]: return True  # only one letter word, thats found
            board[i][j] = None  # whichever is used , is changed to None
            # rest of logic
            dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                if r >= 0 and r < len(board) and c >= 0 and c < len(board[0]) and self.exist_word(board, word[1:], r,
                                                                                                  c):
                    return True
            board[i][j] = word[0]
            return False