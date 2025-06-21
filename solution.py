##problem1 

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        result = []
        board = [[False] * n for i in range (n)]
        
        def backtrack(board,row):
            if row == n:
                newlist = makestr(board)
                result.append(newlist)
                return 

            for col in range (len(board)):

                if issafe(row,col,board):
                    board[row][col] = True

                    backtrack(board, row+1)
                    board[row][col] = False

        def issafe(row,col,board):
            for i in range(0,row):
                if board[i][col] == True:
                    return False
            r = row 
            c = col
            while r >=0 and c >=0:
                if board[r][c] == True:
                    return False
                r-=1
                c-=1
            r = row
            c = col
            while r < len(board) and c < len(board[0]):
                if board[r][c] == True:
                    return False
                r-=1
                c+=1
            return True 

        def makestr(board):

            s = []
            for i in range(len(board)):
                n = ""
                for j in range(len(board[0])):
                    if board[i][j] == True:
                        n += 'Q'
                    else:
                        n+= '.'
                s.append(n)
            return s 
            
        backtrack(board,0)
        return result


## Problem2 - word search 
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:

        myrows = len(board)
        mycols = len(board[0])
        self.visited = set()

        def dfs(r,c,i):

            if i == len(word):
                return True

            if r < 0 or r >= myrows or c < 0 or c>= mycols or word[i] != board[r][c] or (r,c) in self.visited:
                return False

            self.visited.add((r, c))

            ans = dfs(r+1,c,i+1) or dfs(r-1,c,i+1) or dfs(r,c-1,i+1) or dfs(r,c+1,i+1)

            self.visited.remove((r,c))

            return ans

        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if dfs(i, j, 0):
                        return True
        return False

