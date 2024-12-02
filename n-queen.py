class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        board = [[0] * n for _ in range(n)]

        def isSafe(row, col):
            r = row
            c = col
            for i in range(r):
                if board[i][c] == True:
                    return False

            r = row
            c = col
            while(r>=0 and c>=0):
                if board[r][c] == True:
                    return False
                else:
                    r = r -1
                    c = c - 1
            
            r = row
            c = col
            while(r>=0 and c<n):
                if board[r][c] == True:
                    return False
                else:
                    r = r - 1
                    c = c + 1
            return True
        
        def helper(row):
            if row == n:
                listtemp = []
                for i in range(n):
                    string = ""
                    for j in range(n):
                        if board[i][j] == True:
                            string = string + "Q"
                        else:
                            string = string + "."
                    listtemp.append(string)
                result.append(listtemp)
                return

            for col in range(n):
                if isSafe(row,col):
                    board[row][col] = True
                    helper(row+1)
                    board[row][col] = False
        helper(0)
        return result
        


                    