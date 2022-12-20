'''
Time Complexity --> O(n*n)

Space Compelxity --> constant
'''
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        def isSafe(row, col):
            #check upper left
            r = row-1
            c = col-1
            while r>=0 and c>=0:
                if board[r][c]==True:
                    return False
                r-=1
                c-=1
            #check upper 
            r = row-1
            c = col
            while r>=0:
                if board[r][c]==True:
                    return False
                r-=1
            
            #check upper right
            r = row-1
            c = col+1
            while r>=0 and c<n:
                if board[r][c]==True:
                    return False
                r-=1
                c+=1
            return True


        def backtrack(row):
            #base case
            if row==n:
                ls = []
                for i in range(n):
                    s = ''
                    for j in range(n):
                        if board[i][j]==False:
                            s+='.'
                        else:
                            s+='Q'
                    ls.append(s)
                res.append(ls)
                        

            for col in range(n):
                if isSafe(row, col):
                    board[row][col] = True
                    backtrack(row+1)
                    board[row][col] = False


        #check by each row
        res = [] #list of list of strings
        board = [[False for _ in range(n)] for _ in range(n)]
        print(board)
        backtrack(0)
        return res
        