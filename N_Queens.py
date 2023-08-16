# Time Complexity :O(N*N C N)
# Space Complexity :O(N*N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def is_safe(self, i, j, n, chess_board):
        a=i
        b=j
        # check same column
        for k in range(i):
            if(chess_board[k][j]==True):
                return False
        
        # check right diagonal
        while(a>=0 and a<n and b>=0 and b<n):
            if(chess_board[a][b]==True):
                return False
            a-=1
            b+=1
        a=i
        b=j
        # check left diagonal
        while(a>=0 and a<n and b>=0 and b<n):
            if(chess_board[a][b]==True):
                return False
            a-=1
            b-=1
        
        # print(i,j, self.chess_board[i][j])
        return True

    def helper(self, i, n, result, chess_board):
        # base
        if(i==n):
            r=""
            com=[]
            for m in range(n):
                r=""
                for j in range(n):
                    if(chess_board[m][j]):
                        r=r+"Q"
                    else:
                        r=r+"."
                com.append(r)
            result.append(com)
            return
        # logic
        for j in range(n):
            # action
            if(self.is_safe(i,j, n, chess_board)):
                chess_board[i][j]=True
                # recurse
                self.helper(i+1, n, result, chess_board)
                # backtrack
                chess_board[i][j]=False
        pass

    def solveNQueens(self, n: int) -> List[List[str]]:
        result=[]
        chess_board=[[False for i in range(n)] for i in range(n)]
        self.helper(0,n, result, chess_board)
        return result
