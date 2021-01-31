# -*- coding: utf-8 -*-
"""
TC : exponential N * 3^L where N is the board length and L is the word length
SC : O(1) as we are mutating the same array
"""

class Solution:
    def exist(self, board: [[str]], word: str) -> bool:
        #edge case
        if not word or len(word) == 0:
            return False
        m = len(board)
        n = len(board[0])
        #traverse through the grid board of M X N matrix
        for i in range(m):
            for j in range(n):
                if self.backtrack(board,word,i,j,0,m,n):
                    return True
        return False

    def backtrack(self, board: [[str]],word: str, i:int, j:int, index: int, m:int, n:int) -> bool:
        #base case
        if index == len(word):
            return True
        if i < 0 or j < 0 or i == m or j == n or board[i][j] == '#':
            return False
        
        #logic 
        dirs = [(0,1),(-1,0),(1,0),(0,-1)]
        #if the character at index in word is the same as board's coordinates, proceed in a loop
        if word[index] == board[i][j]:
            #place the letter in a temp variable
            temp = board[i][j]
            #declare the cell as visited by marking #
            board[i][j] = '#'
            
            #traverse though the dirs array
            #increment row and column by either left, right, up or down i.e.check neighbors
            for di,dj in dirs:
                r = i + di
                c = j + dj
                #move to next cell
                if self.backtrack(board, word, r, c, index + 1,m,n):
                    return True
            #undo the mutation 
            board[i][j] = temp
        return False
    
