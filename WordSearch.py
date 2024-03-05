'''
TC: O(3^L * (N)) where L is the length of the word we are searching 
        and N is the number of times a character occurs in the board
SC: O(L)
'''
from typing import List

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        ROWS, COLS = len(board), len(board[0])

        def backtrack(r,c, board, letter):
            if letter == len(word):
                return True
            if r<0 or c<0 or r==ROWS or c==COLS or board[r][c]=='.' or board[r][c]!=word[letter]:
                return False
            
            tmp = board[r][c]
            board[r][c] = '.'
                
            p = backtrack(r-1,c,board,letter+1) #Up
            q = backtrack(r,c+1,board,letter+1) #Right
            s = backtrack(r+1,c,board,letter+1) #Down
            t = backtrack(r,c-1,board,letter+1) #Left
            board[r][c] = tmp
            return p or q or s or t

        for i in range(ROWS):
            for j in range(COLS):
                if board[i][j] == word[0]:
                    if backtrack(i, j, board, 0):
                        return True
        return False
s = Solution()
print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))