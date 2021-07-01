'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 51. Word Search Grid

# Given an m x n grid of characters board and a string word,
#  return true if word exists in the grid.


# The word can be constructed from letters of sequentially adjacent cells, 
# where adjacent cells are horizontally or vertically neighboring. 
# The same letter cell may not be used more than once.

#-----------------
# Time Complexity: 
#-----------------
# O(N * 3^L) -  N is number of cells on the board and L is length of word
#               N iterations on the board. For each iteration, we have 3^L
#               choices (stack trace for each cell is a 3-ary tree)


#------------------
# Space Complexity: 
#------------------
# O(L): Length of the word

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.dirs = [[0, 1], [1,0], [-1,0], [0,-1]]
        if len(board) == 0 or len(board[0]) == 0:
            return False
        self.m = len(board)
        self.n = len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] == word[0]:
                    if self.backtrack(board, word, i , j, 1):
                        return True
        return False
    def backtrack(self, board, word, r, c, index ):
        # base
        if index == len(word):
            return True
        #logic
        temp = board[r][c]
        
        board[r][c] = "#" # Use to indicate visited

        for direction in self.dirs:
            i = r + direction[0]
            j = c + direction[1]
            # IF i and j are in bounds 
            # and board[i][j] is the char at current index of word
            if (i>=0 and i < self.m and j >=0 and j<self.n and board[i][j] == word[index]):
                # Recurse on next char in word
                if self.backtrack(board, word, i, j, index + 1):
                    return True
        #backtrack
        board[r][c] = temp
        return False