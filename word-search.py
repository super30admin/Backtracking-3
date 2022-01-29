class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not board: return False
        m = len(board)
        n = len(board[0])
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        def backtrack(board, i, j, index, string):
            # Base
            if index == len(string): return True
                
            if i < 0 or j < 0 or i >= m or j >= n or board[i][j] == "#": return False
            # Logic
            if board[i][j] == word[index]:
                # Action
                ch = board[i][j]
                board[i][j] = '#'
                # Recurse
                for dir in dirs:
                    r = i + dir[0]
                    c = j + dir[1]
                    if backtrack(board, r, c, index + 1, string): return True
                # Backtrack
                board[i][j] = ch
            return False

        for i in range(m):
            for j in range(n):
                if backtrack(board, i, j, 0, word): return True
                # if board[i][j] == word[0]:
        return False
