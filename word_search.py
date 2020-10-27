# O(N * POW(3,K)) TIME AND O(K) SPACE WHERE N IS NO.OF ELEMENTS IN BOARD AND K IS LEN OF WORD

class Solution:
    def exist(self, board, word):
        for i in range(len(board)):
            for j in range(len(board[i])):
                if self.explore(board,word,0,i,j):
                    return True
        return False
    
    def explore(self,board,word,wordidx,rowidx,colidx):
        if wordidx >= len(word):
            return True
        if rowidx < 0 or rowidx == len(board) or colidx < 0 or colidx == len(board[0]) or board[rowidx][colidx] != word[wordidx]:
            return False
        
        prev_char = board[rowidx][colidx]
        board[rowidx][colidx] = "@"
        
        
        for i,j in [(rowidx,colidx+1),(rowidx+1,colidx),(rowidx,colidx-1),(rowidx-1,colidx)]:
            if self.explore(board,word,wordidx+1,i,j):
                return True
        board[rowidx][colidx] = prev_char
        
        return False

        