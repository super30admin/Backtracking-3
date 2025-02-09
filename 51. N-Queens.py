#space: O(n^2)
#Time: O(n!)
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.board=[[False for _ in range(n)] for _ in range(n)]
        self.final= list(list())
        self.backtrack(n,0)
        return self.final

    def backtrack(self, n,r):
        if r == n:
            grid=['' for _ in range(n)]
            for i in range(n):
                tmp=''
                for j in range(n):
                    if self.board[i][j] == True:
                        tmp = tmp+'Q'
                    else:
                        tmp=tmp+'.'
                grid[i]=tmp
            self.final.append(grid)
            return
        
        for j in range(n):
            if self.issafe(r,j,n):
                self.board[r][j] = True
                self.backtrack( n,r+1)
                self.board[r][j] = False
        return 
    
    def issafe(self, r,c,n):
        test_r=r
        test_c=c
        while( test_r>= 0):
            if(self.board[test_r][test_c] == True):
                return False
            test_r-=1
        test_r=r
        test_c=c
        while( test_r>= 0 and test_c>=0):
            if(self.board[test_r][test_c] == True):
                return False
            test_r-=1
            test_c-=1
            
        test_r=r
        test_c=c
        while( test_r>= 0 and test_c<n):
            if(self.board[test_r][test_c] == True):
                return False
            test_r-=1
            test_c+=1
        return True        
