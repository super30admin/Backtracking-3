# Time Complexity: O(n!) where n in the number of rows. 
# Space Complexity:  O(n^2.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        visited = [[False for _ in range(n)] for _ in range(n)]
        self.backtrack(0, n, visited)
        return self.result


    def backtrack(self, row, n, visited):
        #base
        if row == n:
            res = []
            for i in range(len(visited)):
                temp = ""
                for j in range(len(visited[0])):
                    if visited[i][j] == True:
                        temp += "Q"
                    else:
                        temp += "."
                res.append(temp)
            self.result.append(res)
            return



        #action
        for j in range(n):
            if self.checkDiagonals(visited, row, j) == True:
                visited[row][j] = True
                self.backtrack(row+1, n , visited)
                visited[row][j] = False
    
    def checkDiagonals(self, visited, i, j):
        temp_i = i
        temp_j = j
        while(temp_i >= 0 and temp_j >= 0):
            if visited[temp_i][temp_j]:
                return False
            temp_i -=1
            temp_j -= 1

        temp_i = i
        temp_j = j

        while(temp_i >= 0 and temp_j >= 0 and temp_j < len(visited[0]) and temp_i < len(visited)):
            if visited[temp_i][temp_j]:
                return False
            temp_i -=1
            temp_j += 1
        
        temp_i = i
        while(temp_i >= 0):
            if visited[temp_i][j]:
                return False
            temp_i -= 1
        return True
