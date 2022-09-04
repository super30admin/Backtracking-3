# 51. N-Queens

'''
Leetcode all test cases passed: Yes
Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m is no of rows in board
        n is no of columns in board
        l is length of word
        Time Complexity: O(m * n * (3 ^ L)) 
        Space Complexity: O(l)
'''
class Solution:
    def helper(self,r,c,index):
        if index == len(self.word):
            return True
        if r < 0 or  c <0   or r >= len(self.board) or c >= len(self.board[0])or self.board[r][c] == "#": 
            return False
        
        
        if self.board[r][c] == self.word[index]:
            for x,y in [[0,-1],[0,+1],[-1,0],[+1,0]]:
                self.board[r][c] = "#"
                if self.helper(r + x,c + y, index + 1):
                    return True
                self.board[r][c] = self.word[index]
        return False
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board = board
        self.word = word
        for m in range(len(board)):
            for n in range(len(board[0])):
                if board[m][n] == word[0]:
                    if self.helper(m,n,0):
                        return True
                
        return False
