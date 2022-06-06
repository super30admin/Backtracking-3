#Time Complexity: Exponential
#Space Complexity: O(length of word)
class Solution:
    isFound = False
    dirs = [[-1,0],[1,0],[0,1],[0,-1]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.isFound = False
        for i in range(len(board)):
            for j in range(len(board[0])):
                
                if board[i][j] == word[0]:
                    self.helper(i,j,board,word,0)
        return self.isFound
                    
    def helper(self,i,j,board,word,wordpos):
        
        
        
        if wordpos == len(word):
            self.isFound = True    
            return
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]) or board[i][j] == '#':
            return
        if board[i][j] == word[wordpos]:
            char = board[i][j]
            board[i][j] = '#'
            
            for dirn in self.dirs:
                row = i+dirn[0]
                col = j + dirn[1]
                self.helper(row,col,board,word,wordpos+1)
                
            board[i][j] = char
        