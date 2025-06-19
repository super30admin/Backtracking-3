# Time Complexity : O(n!)
# Space Complexity : O(n^n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No
# Three line explanation of solution in plain english:
"""1. We create a boolean chess board and use recursion with for loop to explore each row and columns.
2. At each row, we check all columns to see if a queen can be safely placed by checking the column,left and right diagonals.
3. and then backtrack by resetting cells to explore other safe placements of the queen."""
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        
        """
        i, j = n, n
        #create a board of nxn matrix
        board = [[False for _ in range(i)] for _ in range(j)]
        res=[]
        #backtrack function for each row and appending the states of each row to the result
        def backtrack(board,r,res):
            #once end of the board is reached check each cells and update the results
            if r==len(board):
                row=[]
                for i in range(n):
                    queens=""
                    for j in range(n):
                        if(board[i][j]):
                            queens+="Q"
                        else:
                            queens+="."
                    #save the state of each row in a list
                    row.append(queens)
                #append the solution to the result array
                res.append(row)
            #for a given row iteratively check if the queen can be safely placed in the columns  
            for c in range(n):
                #call isSafe function to check if queen can be placed
                if isSafe(board,r,c):
                    #mark cells true if the queen can be placed
                    board[r][c]=True
                    #once the queen is placed recursively explore next rows
                    backtrack(board,r+1,res)
                    #reset the cells to explore other cells in the same row
                    board[r][c]=False
        #an isSafe fuction to determine the placement of the queen
        def isSafe(board,r,c):
            #check if any queen is placed row wise
            for i in range(r):
                if board[i][c]: return False
            #check for cells horizontally towards left and return False if queen is present
            i,j=r,c
            while i>=0 and j>=0:
                if board[i][j]:return False
                i-=1
                j-=1
            i,j=r,c
            #check for cells horizontally towards right and return False if queen is present
            while i>=0 and j<n:
                if board[i][j]:return False
                i-=1
                j+=1
            return True
        #call the function from first row
        backtrack(board,0,res)
        return res


