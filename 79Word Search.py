class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        def backtrack(board, word, index, r, c):
            if index == len(word): return True
            if r < 0 or c < 0 or r == m or c == n or board[r][c] == '#': return False
                
            if board[r][c] == word[index]:
                ch = board[r][c]
                board[r][c] = '#'
                for di in dirs:
                    nr = r + di[0]
                    nc = c + di[1]
                    if backtrack(board, word, index + 1, nr, nc):
                        return True
                board[r][c] =  ch
                return False
        if len(board) == None: return False
        m = len(board)
        n = len(board[0])
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        for i in range(0, m):
            for j in range(0, n):
                if board[i][j] == word[0]:
                    if backtrack(board, word, 0, i, j):
                        return True
                    

# T.C => O(m * n) (3 ** l) with the grid its m*n and since we going to 3 direction for backtraking with length ofh the string
# S.C => O(L) => backtrack recursive stack space, till length of the string
# Approach => Here we traverse trough a mtrix, If we found a character matching then just change the current character to the #. If the next word is not matched the just backtrach check its other three direction. Still we need to back brack just go back and change the # to the ch again. 
            
  