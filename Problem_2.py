class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board == None or board[0] == None or len(board) == 0 or len(board[0]) == 0:
            return False
        self.m = len(board)
        self.n = len(board[0])
        self.dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, word, i, j, 1):
                        return True
        return False
    
    def backtrack(self, board: List[List[str]], word: str, r: int, c: int, index: int) -> bool:
        # base
        if index == len(word):
            return True
        
        # logic
        temp = board[r][c]
        board[r][c] = '#'
        for dir in self.dirs:
            i = r + dir[0]
            j = c + dir[1]
            if i >=0 and i < self.m and j >= 0 and j < self.n and board[i][j] == word[index]:
                if self.backtrack(board, word, i, j, index+1):
                    return True
        board[r][c] = temp
        return False


# Time Complexity : O(N * 2^L)    where N is m * n and L is length of word
# Space Complexity : O(l) where L is length of word