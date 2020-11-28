"""
Time Complexity O(4^N)


"""
class Solution_wordsearch:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board=board
        if not word:
            return True
        
        for i in range (len(self.board)):
            for j in range(len(self.board[0])):
                if self.board[i][j]==word[0]:
                    if not word[1:]:
                        return True
                    if self.helper(word,i,j):
                        return True
        return False
        
        
    def helper(self,word,row,column):
        if not word:
            return True
            
        if word[0]!=self.board[row][column]:
            return False
            
        temp=self.board[row][column]
        self.board[row][column]="*"
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        for dir in dirs:
            r=row+dir[0]
            c=column+dir[1]
            if r>=0 and r<len(self.board) and c>=0 and c<len(self.board[0]):
                if self.helper(word[1:],r,c):
                    return True
        self.board[row][column]=temp
        return False
        
        
        