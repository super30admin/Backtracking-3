# Time Complexity :O(n!)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def right(self,row,col,helper):
        i = row-1
        #check col
        while i >=0:
            if helper[i][col] == 'Q':
                return False
            i-=1
        i = row-1
        j = col-1
        #check diagonals
        while i >=0 and j >=0:
            if helper[i][j] == 'Q':
                return False
            i -=1
            j -=1
            
        i = row-1
        j = col+1
        while i >=0 and j < len(helper):
            if helper[i][j] == 'Q':
                return False
            i -=1
            j +=1
        return True
            
        
    def backtrack(self,n,row,helper,res):
        #base If you passed all rows
        if row >= n:
            #append line by line to solution then append solution to res
            sol = []
            for i in range(len(helper)):
                sol.append("".join(helper[i]))
            res.append(sol)
        
        #logic
        for i in range(n):
            # if you can put in this column
            if(self.right(row,i,helper)):
                #put queen in this column
                helper[row][i] = 'Q'
                #recurse on rest of columns
                self.backtrack(n,row+1,helper,res)
                #remove queen from this place and try another place
                helper[row][i] = '.'

    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """
        # create res and helper
        res = []
        if n == 0 :
            return res
        helper = [['.']*n for i in range(n)]
        #backtrack
        self.backtrack(n,0,helper,res)
        return res