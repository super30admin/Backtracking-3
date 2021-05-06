# Recursively calculate all the possible words that can be formed from a given position
# We can possibly move towards 3 directions from any cell, excluding the direction we came from
# Use backtracking to keep track of the word during recursion calls
# Time Complexity is O(N*3^L), where N is the size of the board and L is the length of the word
# Space complexity is O(L), for maintaining the word list
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if(len(board[0]) == 1):
            return board[0][0] == word
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(self.backtrack(i,j,word,board,0)):
                    #print(i,j)
                    return True
        return False
    def backtrack(self,i,j,word,board,index):
        if(index == len(word)):
            return True
        if(board[i][j] != word[index]):
            return False
        c = board[i][j]
        board[i][j] = '-1'
        dirs = [(0,1),(0,-1),(-1,0),(1,0)]
        for d in dirs:
            row = i+d[0]
            col = j+d[1]
            if(row<0 or row>=len(board) or col < 0 or col >= len(board[0])):
                continue
            currOut = self.backtrack(row,col,word,board,index+1)
            if(currOut):
                return True
        board[i][j] = c
        return False