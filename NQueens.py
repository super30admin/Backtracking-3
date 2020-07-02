----------------------------------N Queens -------------------------------------
# Time Complexity : O(N!) N is the length of grid
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here I have used backtracking solution where I choose a number or not choose a column by iterating through the matrix.
#Here I choose the position and check weather that row is in row set , column is in column set and check the 2 diagonals .
#If the position is not present then i will change the position to Q and call dfs on the next row. If we encounter any issue ,
# Then I wil, backtrack by replacing 'Q' with the '.'


import copy
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        row = set()
        col = set()
        dia1 =set()
        dia2 = set()
        temp = [['.' for i in range(n)] for j in range(n) ]
        
        def backtrack(n, temp, index):
            
            # basecase
            if index == n:
                new = copy.deepcopy(temp)
                
                for i in range(len(new)):
                    new[i]= "".join(new[i])
                res.append(new)
                
            # Logic
            for j in range(n):
                if index not in row and j not in col and (index+j) not in dia1 and index-j not in dia2:
                    temp[index][j] = 'Q'
                    row.add(index)
                    col.add(j)
                    dia1.add(index+j)
                    dia2.add(index-j)

                    backtrack(n,temp, index+1)

                    temp[index][j] = '.'
                    row.remove(index)
                    col.remove(j)
                    dia1.remove(index+j)
                    dia2.remove(index-j)
        res = []
        backtrack(n,temp, 0)
        return res