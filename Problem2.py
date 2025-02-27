class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n = len(board[0])

        for i in range(m):
            for j in range(n):
                if word[0] == board[i][j]:
                    if self.backtrack(board,i,j,0,word):
                        return True
        
        return False

    def backtrack(self, board: List[List[str]],r: int, c: int,idx: int, word: str) -> bool:
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        #base case
        if idx == len(word):
            return True
        if r < 0 or c < 0 or r == len(board) or c == len(board[0]) or board[r][c] == '#':
            return False

        #logic
        if board[r][c] == word[idx]:
            #action
            board[r][c] = '#'
            #recurse
            for dire in dirs:
                nr = r + dire[0]
                nc = c + dire[1]
                if self.backtrack(board,nr,nc,idx + 1,word):
                    return True

            #backtrack
            board[r][c] = word[idx]

        