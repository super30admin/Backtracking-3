# Accepted on leetcode(79)
# time - O((M*N) * 3^P ->  p is the length of string), space - O(M*N)
# Using backtracking approach
'''
First try to find the first character of the word in the grid. Then start a dfs on it and if some character is not found backtrack from the path and traverse other paths.
'''


class Solution:
    def exist(self, board, word: str) -> bool:
        # Edge case
        if not board: return False
        if not word: return True
        m = len(board)
        n = len(board[0])
        # using a visited matrix so that we dont include the path previously visited.
        visited = [[False for i in range(n)] for j in range(m)]
        for i in range(m):
            for j in range(n):
                if self.exist_word(board, word, i, j, visited):
                    return True
        return False

    def exist_word(self, board, word, i, j, visited):
        # base case
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or visited[i][j]:
            return False
        # Logic
        if board[i][j] == word[0]:
            if len(word) == 1: return True  # only one letter word, thats found
            visited[i][j] = True  # make visited true if the path is already explored.
            # rest of logic
            dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
            for dir in dirs:
                r = i + dir[0]
                c = j + dir[1]
                if self.exist_word(board, word[1:], r, c, visited): return True
            # backtracking
            visited[i][j] = False
        return False