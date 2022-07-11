'''
Time Complexity: O(m*n*4^L) where L is the lenght of the word
Space Complexity: O(L) where L is the lenght of the word
Run on Leetcode: YES
'''
class Solution:
    direction = [[-1,0], [0,-1],[0,1],[1,0]]
    def exist(self, board: list[list[str]], word: str) -> bool:
        self.flag = False
        def backtrack(word: str, r: int, c: int):
            #base
            if len(word) == 0:
                self.flag = True
                return
            #logic
            for direct in self.direction:
                nr = r + direct[0]
                nc = c + direct[1]
                if (nr in range(0,len(board))) and (nc in range(0,len(board[0]))) and board[nr][nc] == word[0] and not self.flag:
                    #action
                    board[nr][nc] = '#'
                    #recurse
                    backtrack(word[1:], nr, nc)
                    #backtrack
                    board[nr][nc] = word[0]
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0] and not self.flag:
                    board[i][j] = '#'
                    backtrack(word[1:], i, j)
                    board[i][j] = word[0]
        return self.flag