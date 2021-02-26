# O(N * 4 ^ L) time and O(L) SPACE WHERE N IS LEN(BOARD) 
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if self.explore(board,word,i,j,0):
                        return True
        return False
        
    def explore(self,board,word,i,j,idx):
        if idx == len(word):
            return True
        
        if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]) or board[i][j] != word[idx]:
            return False
        
        prev_char = board[i][j]
        board[i][j] = "*"
            
        for direction in [[1,0],[0,1],[-1,0],[0,-1]]:
            row = i + direction[0]
            col = j + direction[1]
            if self.explore(board,word,row,col,idx+1):
                return True
        
        board[i][j] = prev_char
        return False
        
        