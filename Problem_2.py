"""
Problem : 2

Time Complexity : O(3^(n))
Space Complexity : O(n) //n=length of word

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

First iterating over the board to find the 1st letter of the word, then performing recursive search operation on that cell,
to find next letters in the word, marking them as visited, and again recursively searching neighbors of that cell,
after it is done unmarking the cell to make it available for next recursive call of another neighbor, repeating the process until reached
the end of the board or the word is found

"""

# Word Search

class Solution(object):
    def __init__(self):
        self.direction=[(0,1),(1,0),(-1,0),(0,-1)]
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not board:
            return board
        
        m=len(board)
        n=len(board[0])
        for i in range(m):
            for j in range(n):
                if self.backtrack(board,word,0,i,j):
                    return True
        return False
    def backtrack(self,board,word,idx,i,j):
        # base
        if idx==len(word):
            return True
        if i<0 or j<0 or i==len(board) or j==len(board[0]) or board[i][j]=="#":
            return False
        
        # logic
        if board[i][j]==word[idx]:
            # temp=word[idx]
            board[i][j]="#"
            for dirs in self.direction:
                r=i+dirs[0]
                c=j+dirs[1]
                if self.backtrack(board,word,idx+1,r,c):
                    return True
            # backtrack
            board[i][j]=word[idx]
        return False