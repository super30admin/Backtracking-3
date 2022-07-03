#TC:O(n!)
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        result=[]
        if n==0: return result
        board=[[False for i in range(n)] for i in range(n)]
        
        def isSafe(board,r,c,n):
            #col up
            for i in range(r):
                if board[i][c]: return False
            #diagonal up left
            #while r--,c--
            i=r
            j=c
            while(i>=0 and j>=0):
                if board[i][j]: 
                    return False
                i-=1
                j-=1
            #diagonal up right
            #while r--,c++
            i=r
            j=c
            while(i>=0 and j<n):
                if board[i][j]: 
                    return False
                i-=1
                j+=1
            return True
        
        def backtrack(board,r,n):
            #base
            if r==n:
                li=[]
                for i in range(n):
                    sb=""
                    for j in range(n):
                        if board[i][j]:
                            sb+='Q'
                        else:
                            sb+='.'
                    li.append(sb)
                result.append(li)
                return

            #logic
            for i in range(n):
                if isSafe(board,r,i,n):
                    #action
                    board[r][i]=True
                    #recurse
                    backtrack(board,r+1,n)
                    #backtrack
                    board[r][i]=False
            
        backtrack(board,0,n)
        return result
        