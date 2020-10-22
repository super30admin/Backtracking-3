# backtracking
# O(n*3^L)
# O(L)
# Yes, It passed all test cases on leetcode
# No problems

class Solution:
    def exist(self, board, word: str) -> bool:
        self.rows = len(board)
        self.cols = len(board[0])
        self.board = board
        
        for row in range(self.rows):
            for col in range(self.cols):
                if self.finder(row,col,word):
                    return True
        return False
    
    def finder(self,row,col,word):
        if len(word)==0:
            return True
        if row<0 or row==self.rows or col<0 or col==self.cols or self.board[row][col]!=word[0]:
            return False
        #ans = False
        prev = self.board[row][col]
        self.board[row][col] = "#"
        
        for i,j in [(0,1),(-1,0),(1,0),(0,-1)]:
            if self.finder(row+i,col+j,word[1:]):
                return True
        
        self.board[row][col] = prev
        return False
        

