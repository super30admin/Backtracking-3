class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        result = []
        board = [[0 for _ in range(n)]for _ in range(n)]
        if not n:
            return result
        self.backtrack(n, 0, result, board)
        return result
    
    def backtrack(self, n, row, result, board):
        def isSafe(row, col):
            #column up
            for i in range(0,row):
                if board[i][col] == 1:
                    return False
            #diagonal up left
            i, j = row-1, col-1
            while(i>=0 and j>=0):
                if board[i][j] == 1:
                    return False
                i-=1
                j-=1
            #diagonal up right
            i, j = row-1, col+1
            while(i>=0 and j<n):
                if board[i][j] == 1:
                    return False
                i-=1
                j+=1
            return True
        #base
        if row == n:
            temp = []
            for i in range(n):
                string = ""
                for j in range(n):
                    if board[i][j] == 1:
                        string+='Q'
                    else:
                        string+='.'
                temp.append(string)
            result.append(temp)
            return
        #logic
        for i in range(n):
            if isSafe(row, i):
                #action
                board[row][i] = 1
                #recurse
                self.backtrack(n, row+1, result, board)
                #backtrack
                board[row][i] = 0


#time complexity - O(n!) as every cell of the board is tested out

#space complexity - O(n)

#all test cases passed