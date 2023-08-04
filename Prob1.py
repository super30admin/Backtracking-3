# Time Complexity : O(n!) -> In 1st row, each element has n options, 2nd row elements each have n-2 options and so on -> nxn-2xn-4...=n!
# Space Complexity : O(n^2)
# Traverse the board row wise, check if a Queen can be placed at a particular index by making sure there are no Queens in the left diagonal, right diagonal and in the current column. 
# If it is safe to place a Queen, move to the next row since there can be only one Queen in a row. 
# Repeat the process until the end of board is reached. At any point, if it is not possible to add a queen after a certain row, backtrack by removing the queen at the current row.

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        board=[[False for _ in range(n)] for _ in range(n)]
        res=[]


        def isSafe(board, r, c):
            # column up
            for i in range(r):
                if board[i][c]:
                    return False
            
            # diagonal up - right
            x, y = r, c
            while x >= 0 and y < len(board):
                if board[x][y]:
                    return False
                x -= 1
                y += 1
            
            # diagonal up - left
            x, y = r, c
            while x >= 0 and y >= 0:
                if board[x][y]:
                    return False
                x -= 1
                y -= 1
            return True


        def helper(board,r):
            #base
            if r==n:
                li=[]
                for i in range(n):
                    temp=''
                    for j in range(n):
                        if board[i][j]:
                            temp+='Q'
                        else:
                            temp+='.'
                    li.append(temp)
                res.append(li)

            #logic
            for j in range(n):
                if isSafe(board,r,j):
                    #action
                    board[r][j]=True
                    #recurse
                    helper(board,r+1)
                    #backtrack
                    board[r][j]=False

        helper(board,0)
        return res

