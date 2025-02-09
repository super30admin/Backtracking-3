#space: O(length of string)
#Time: O(m*n* 3(directions)^L(length of string))

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if board is None:
            return 
        m = len(board)
        n= len(board[0])

        for i in range(m):
            for j in range(n):
                if self.backtrack(board, word, i,j,0) == True:
                    return True
        

        return False

    def backtrack(self, board, word, r,c, index):
        
        #base
        if (index == len(word)):
            return True
        if ( r<0 or c < 0 or r== len(board) or c == len(board[0]) or board[r][c] == "*" ):
            return
        
        
        
        dirs= [[0,1],[0,-1],[1,0],[-1,0]]
        
        #logic
        if ( board[r][c] == word[index]):
            board[r][c]="*"
            for direction in dirs:
                nr,nc= r+direction[0], c + direction[1]
                if self.backtrack(board,word,nr, nc, index+1):
                    return True
            board[r][c] = word[index]
        return False

        
