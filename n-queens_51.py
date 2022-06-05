
#Approach: Backtracking on boolean board
#Time Complexity : O(N!), Since we have N choices in the first row, then N-1 choices in the second row and so on so the overall complexity become O(N!)
#Space Complexity: O(N*N), Just the board and recursive stack space
#It successfully runs on leetcode

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        def backtrack(b, r):
            #if we found valid board then convert it to string list
            if r==m:
                l = []
                for i in range(m):
                    s = ""
                    for j in range(m):
                        if b[i][j]:
                            s += "Q"
                        else:
                            s += "."
                    l.append(s)
                result.append(l)
                return
            #action and backtrack
            for c in range(m):
                if issafe(b, r, c):
                    b[r][c] = True
                    backtrack(b, r+1)
                    b[r][c] = False
            
        
        def issafe(b, r, c):
            #for same column above
            for i in range(r):
                if b[i][c]:
                    return False
                
            #diagnoal up left    
            i, j = r,c
            while i >= 0 and j >= 0:
                if b[i][j]:
                    return False
                i-=1
                j-=1
                 
            #diagnoal up right
            i, j = r,c
            while i >= 0 and j < m:
                if b[i][j]:
                    return False
                i-=1
                j+=1
            return True
        
       #boolean board
        b = [[False for i in range(n)] for j in range(n)]              
        m = n
        result = []
        backtrack(b, 0)
        return result
                
                