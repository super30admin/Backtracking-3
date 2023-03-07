#All TC passed on leetcode

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:

        #Here we try all combinations of adding queen in every column of a row.
        #Time complexity: O(n!) => each row has n*(n-2)*(n-4)...choices of adding thr queen
        #Space complexity: O(n^2)+O(n) => here n^2 to store a combination of board each time and n for stack space, max stack tree size can go size n
        board = [[False]*n for i in range(n)]
        res = []

        def helper(board, r, n):

            #adding this combination to result set, when r has crossed last row.
            if r==n:
                ans = []
                for i in range(n):
                    s = ""
                    for j in range(n):
                        if board[i][j]==True:
                            s = s+"Q"
                        else:
                            s = s+"."
                    ans.append(s)
                res.append(ans)
            
            #iterating through all columns.
            for c in range(n):
                if self.isSafe(board, r, c):
                    board[r][c] = True #action

                    helper(board, r+1, n) #recurse

                    board[r][c] = False #backtrack

        helper(board, 0, n)
        return res

    #checking if current cell is safe to add queen. We check if there are any queens in same column, in cells diagnolly left up and in cellsa diagonally right up. We return True if it is safe to add else false.
    def isSafe(self, board, r, c):
        m = len(board)
        for i in range(m):
            if board[i][c]==True:
                return False

        i=r
        j=c
        while i>=0 and j>=0:
            if board[i][j]==True:
                return False
            i-=1
            j-=1

        i=r
        j=c
        while i>=0 and j<m:
            if board[i][j]==True:
                return False
            i-=1
            j+=1

        return True