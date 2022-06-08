
'''
time complexity: O(n!)
space complexity: O(n^2)
'''
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        global m
        global sb 
        sb = []
        
        board = [[False for _ in range(n)] for i in range(n)]
        
        m = n
        
        self.helper(board,0)
        return sb
    def helper(self,board,r):
        #base case
        if(r==m):
            s = []
            st = []
            for i in range(m):
                st = []
                for j in range(m):
                    if(board[i][j]==True):
                        st.append("Q")
                    else:
                        st.append(".")
                s.append("".join(st))
            sb.append(s)
            return
        #logic
        for c in range(m):
            if(self.isSafe(board,r,c)):
                board[r][c]=True
                self.helper(board,r+1)
                board[r][c]=False
        
        
    def isSafe(seld,board,r,c):
        
        for i in range(r):
            if(board[i][c]): return False
        
        i=r
        j=c
        while(i>=0 and j>=0):
            if(board[i][j]): return False
            i-=1
            j-=1
                
        i=r
        j=c 
        while(i>=0 and j<m):
            if(board[i][j]): return False
            i-=1
            j+=1
        return True
        
        