

# Time Complexity : O(n*m!)
# Space Complexity : O(n)  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        
        def isValid(board, c, r):
            #check whether positon is alredy occupied
            if c not in col and r - c not in left_diagonal and r + c not in right_diagonal:
                return True
            return False
    
        def backtrack(board, queensLeft, row):
            if queensLeft == 0:
                output.append(makeBoard(board))

            for c in range(len(board)):
                #check for valid position
                if isValid(board, c, row):
                    #backtracking
                    board[row][c] = "Q"
                    right_diagonal.add(row+c)
                    left_diagonal.add(row-c)
                    col.add(c)

                    backtrack(board, queensLeft - 1, row + 1)

                    board[row][c] = "."
                    right_diagonal.remove(row+c)
                    left_diagonal.remove(row-c)
                    col.remove(c)
    
        def makeBoard(board):
            res = []
            for i in range(len(board)):
                temp = ''
                for j in range(len(board[0])):
                    temp += board[i][j]
                res.append(temp)
            return res
    
        #driver code
        if n == 1:
            return [["Q"]]
        board = [['.' for _ in range(n)] for _ in range(n)]
        
        right_diagonal = set()
        left_diagonal = set()
        col = set()
        output = []
        
        backtrack(board, n, 0)
        
        return output
