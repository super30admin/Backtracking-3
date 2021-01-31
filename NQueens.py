# -*- coding: utf-8 -*-
"""
Time Complexity : Exponential or O(N!) where N is the given value at input 
Space Complexity: O(N) where N is the given value at input 
"""

class Solution:
    def solveNQueens(self, n: int):
        output = []
        board = []
        cols = set()
        sums = set()
        diffs = set()
        self.dfs(0,n,cols,sums,diffs,board,output)
        return output
        

    def dfs(self,i,n,cols:set(),sums:set(),diffs:set(),board:[],output:[]):
            #base case
            #when index reaches grid length (NxN)
            if i == n:
                output.append(list(board))
            #logic
            #NxN Queens problem solved via backtracking algorithm
            
            #row index is assigned with index value initiated with 0
            #traverse the grid column wise
            #check for the possible cells where other queens can attack i.e. same column and same row and two diagonals
            #diagonal 1 (top left to bottom right) is current cell of queen with r - c
            #diagonal 2 (top right to bottom left) is current cell coordinates of the queen i.e. r + c
            #while placing a temporary queen, we need to see whether it will get attacked by cells in same column
            #same row or diagonal 1 and diagonal 2
            #we use 3 sets : cols, sums and diffs
            #board is a list where we append the temporary coordinates of the current queen
            #function is recursively called with index + 1
            #if next queen is placed at a possible attack cell, all operations are undone
            #when index reaches grid length, output - an accumulated list of board lists is returned
            row_idx = i
            for col_idx in range(n):
                if col_idx not in cols and row_idx + col_idx not in sums and row_idx - col_idx not in diffs:
                    cols.add(col_idx)
                    sums.add(row_idx + col_idx)
                    diffs.add(row_idx - col_idx)
                    #temp placement of queen and board is appended
                    board.append("." * col_idx + "Q" + "." * (n - col_idx - 1))
                    #move to the next row
                    self.dfs(i + 1,n,cols,sums,diffs,board,output)
                    
                    #if wrong move, undo all operations
                    board.pop()
                    cols.remove(col_idx)
                    sums.remove(row_idx + col_idx)
                    diffs.remove(row_idx - col_idx)
            return output

                
S = Solution()
print(S.solveNQueens(4))
