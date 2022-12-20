'''
Time Complexity --> O((m*n)* 3^l) where l is the length of the word m is the length of board and n is length of board[0]

Space Complexity --> O(l)
'''
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        def backtrack(board, word, index, row, col):
            if index>=len(word):
                return True
            if row<0 or row>=m or col<0 or col>=n or board[row][col]=='#':
                return False
            
            if board[row][col]==word[index]:
                ch = board[row][col]
                board[row][col]='#'
                for d in dir:
                    nr = row+d[0]
                    nc = col+d[1]
                    if(backtrack(board, word, index+1, nr, nc)):
                        return True
                board[row][col]=ch


        m = len(board)
        n = len(board[0])
        #will use dfs appraoch with backtracking
        index = 0
        dir = [[-1,0],[1,0],[0,-1],[0,1]]
        for i in range(len(board)):
            for j in range(len(board[i])):
                if(backtrack(board, word, 0, i, j)):
                    return True
        

        return False

        