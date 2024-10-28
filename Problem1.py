#51. N-Queens
class Solution(object):
    def solveNQueens(self, n): #T.C-> O(N!) , S.C -> O(N^2)
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.result = []
        self.board = [[False for _ in range(n)] for _ in range(n)]
        self.dfs(0,n)
        return self.result

    def dfs(self,i,n):
        #base case
        if i == n:
            path = []
            for r in range(n):
                string = ''
                for c in range(n):
                    if self.board[r][c] == True:
                        string+='Q'
                    else:
                        string+='.'
                path.append(string)
            self.result.append(copy.deepcopy(path))
            return 

        #logic
        for j in range(n):
            if self.isSafe(i,j,n):
                self.board[i][j] = True
                self.dfs(i+1,n)
                self.board[i][j] = False
    
    def isSafe(self,i,j,n):

        r = i
        c = j

        while r>=0: #check col 
            if self.board[r][c]: return False
            r-=1
        r = i
        c = j

        while r>=0 and c>=0: #left digonal
            if self.board[r][c]: return False
            r-=1
            c-=1
        r = i
        c = j
        while r >= 0 and c < n:
            if self.board[r][c]: return False
            r-=1
            c+=1
        return True

        
