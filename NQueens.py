# // Time Complexity : O(N!)
# // Space Complexity : O(N^2)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach in three sentences only

class solution:
    '''
    We are solving this question using backtracking. for each cell we see if it is safe to put a queen. we check if is safe if it is not in same column , not in any diagonal. 

    then return True. then we add q to the set, add the col to the set add r+c to set and r-c to a set. and recurse with new row (r+1). after recursion we backtrack by removing all the above addiitons we made

    in our base case if r ==n then we add the board to our result.
    '''
    def Nqueens(self, n):
        self.res = []
        self.col = set()
        self.posDiag = set()
        self.negDiag = set()
        self.board = [["."]*n for i in range(n)]
        self.helper(0)

        return self.res

    
    def helper(self, r,n):

    ##base
        if r == n:
            copy = ["".join(row) for row in self.board]
            self.res.append(copy)
            return 

    ##logic

        for c in range(n):
            if self.isSafe(r,c):

                self.board[r][c]= "Q"
                self.col.add(c)
                self.posDiag.add(r+c)
                self.negDiag.add(r-c)

                self.helper(r+1,n)

                self.col.remove(c)
                self.posDiag.remove(r+c)
                self.negDiag.remove(r-c)
                self.board[r][c]="."
    
    def isSafe(self, r, c):

        if c in self.col or r+c in self.posDiag or r-c in self.NegDiag:
            return False
        
        return True