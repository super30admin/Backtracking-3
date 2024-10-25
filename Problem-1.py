# T.C = n! S.C = O(n^2)
class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        self.result = []
        self.board = [[0 for _ in range(n)] for _ in range(n)]
        self.helper(0,n)
        return self.result

    def helper(self,i,n):

        if(i == n):
            path = []
            for r in range(n):
                sb = []
                for c in range(n):
                    if(self.board[r][c]):
                        sb.append("Q")
                    else:
                        sb.append(".")
                path.append("".join(sb))
            self.result.append(path)
            return

        for j in range(n):
            if(self.isSafe(i,j,n)):
                self.board[i][j] = True
                self.helper(i+1,n)
                self.board[i][j] = False

    def isSafe(self,i,j,n):
        r = i
        c = j

        while(r>=0):
            if(self.board[r][c]):
                return False
            r-=1

        r = i
        c = j

        while(r>=0 and c>=0):
            if(self.board[r][c]):
                return False
            r-=1
            c-=1

        r = i
        c = j

        while(r>=0 and c<n):
            if(self.board[r][c]):
                return False
            r-=1
            c+=1

        return True
        