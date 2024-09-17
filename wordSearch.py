"""
# Problem2
Word Search(https://leetcode.com/problems/word-search/)

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.


"""
def wordSearch(self, board, word):
    m = len(board)
    n = len(board[0])

    for i in range(m):
        for j in range(n):
            if board[i][j]== word(0)
                if self.backTrack( self,board, i, j, 0, word):
                    return True
    return False

directions = [[0,1], [1,0], [-1,0], [0,-1]]

def backTrack(self,board, i, j, index, word):
    if index == len(word)-1:
        return True

    temp = board[i][j]
    board[i][j]= '#'

    for direct in directions:
        r = i + direct[0]
        c = j + direct[1]

        if r < len(board) and r >=0 and c < len(board[0]) and c >=0 and board[r][c] == word(i+1):
            if self.dfs(board, r , c ,index+1, word):
                return True

    board[i][j] = temp

    return False
