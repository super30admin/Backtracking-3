class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dir = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        self.m = len(board)
        self.n = len(board[0])
        self.flag = False

        def dfs(board, i, j, word, id):

            if id == len(word):
                self.flag = True
                return
            
            if i < 0 or i == self.m or j < 0 or j == self.n or board[i][j] == "#":
                return
            
            
            if board[i][j] == word[id]:
                board[i][j] = '#'

                for d in self.dir:
                    r = d[0] + i
                    c = d[1] + j
                    dfs(board, r, c, word, id + 1)
                
                board[i][j] = word[id]
        
        for i in range(self.m):
            for j in range(self.n):
                if not self.flag:
                    dfs(board,i,j,word,0)
                else:
                    break
        return self.flag
