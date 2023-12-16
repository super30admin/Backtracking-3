class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.row = len(board)
        self.column = len(board[0])
        self.flag= False
        if self.row==1 and self.column == 1 and board[0][0]==word:
            return True

        for i in range(self.row):
            for j in range(self.column):
                if not self.flag:
                    self.dfs(board,i,j,word,0)


        return self.flag

    def dfs(self,board,row,col,word,idx):
        if idx==len(word):
            self.flag= True
            return

        if row<0 or col<0 or row>=self.row or col>=self.column or board[row][col]=="#":
            return

        if board[row][col]!=word[idx]:
            return

        temp = board[row][col]
        board[row][col] = "#"

        if row >= 1:
            self.dfs(board, row - 1, col, word, idx + 1)
        if row < self.row - 1:
            self.dfs(board, row + 1, col, word, idx + 1)
        if col >= 1:
            self.dfs(board, row, col - 1, word, idx + 1)
        if col < self.column - 1:
            self.dfs(board, row, col + 1, word, idx + 1)

        board[row][col] = temp

        

        