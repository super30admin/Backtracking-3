# Time Complexity: Exponential O(m*n*3^L)
# Space Complexity: O(m*n)
# Mainting the visited matrix
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        self.n = len(board[0])
        self.word = word
        self.board = board
        self.visited = [[False for _ in range(self.n)] for _ in range(self.m)]
        self.dirs = [(0, 1), (1, 0), (-1, 0), (0, -1)]

        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(i, j, 0):
                    return True
        return False

    def dfs(self, i, j, idx):
        # Base
        if i<0 or i>=self.m or j<0 or j>= self.n or self.visited[i][j]:
            return False
        if self.board[i][j] != self.word[idx]:
            return False
        if idx == len(self.word) - 1:
            return True
        
        # Logic
        self.visited[i][j] = True
        for dx, dy in self.dirs:
            if self.dfs(i+dx,j+dy,idx+1):
                return True
        # Backtrack
        self.visited[i][j] = False
        return False
    

    
# Time Complexity: Exponential O(m*n*3^L)
# Space Complexity: O(m*n)
# Inplace solution without visited matrix
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.m = len(board)
        if self.m == 0 or not board or len(word) == 0:
            return False
        self.n = len(board[0])

        for i in range(self.m):
            for j in range(self.n):
                if self.dfs(board, word, i, j):
                    return True
        return False

    def dfs(self, board: List[List[str]], word: str, i: int, j: int) -> bool:
        # base case
        if i < 0 or i >= self.m or j < 0 or j >= self.n or board[i][j] == '#':
            return False

        # logic
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]

        if board[i][j] == word[0]:
            if len(word) == 1:
                return True

            prev = board[i][j]
            board[i][j] = '#'  # mark visited

            for dx, dy in dirs:
                if self.dfs(board, word[1:], i + dx, j + dy):
                    return True

            # backtrack
            board[i][j] = prev

        return False