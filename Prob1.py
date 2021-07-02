#Time complexity: O(n!)
#Space Complexity: O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def solveNQueens(self, n):
        """
        :type n: int
        :rtype: List[List[str]]
        """

        # auxilary space for marking the queens
        self.boolRes = [[False for x in xrange(n)] for x in xrange(n)]
        #result matrix returned as output
        self.res = []
        self.n = n
        def backtrack(i,n):
            #base
            #if all n queens found then make the resultant matrix and add it to the list
            #if not, then proceed further
            if i==n:
                rList = []
                for k in xrange(len(self.boolRes)):
                    rstr = ''
                    for l in xrange(len(self.boolRes[0])):
                        if self.boolRes[k][l]:
                            rstr += 'Q'
                        else:
                            rstr += '.'
                    rList.append(rstr)
                self.res.append(rList)
                return
            #logic
            # iterate over columns as we are iterating over rows using recursion
            # place queen at each column unit and then find if it is a good position to place the queen
            #if it is a decent place to put the queen, then find position of next queen using recursion
            for j in xrange(n):
                if isSafe(self.boolRes,i,j):
                    #action
                    self.boolRes[i][j]  = True
                    #recurse
                    backtrack(i+1,n)
                    #backtrack
                    self.boolRes[i][j] = False
        def isSafe(mat,i,j):
            #parse up rows to check same column
            for k in xrange(i):
                if self.boolRes[k][j]:
                    return False
            #right up diagnol check
            k,l = i,j
            while k>=0 and l<self.n:
                if self.boolRes[k][l]:
                    return False
                k -= 1
                l += 1
                
            #left up diagnol check
            k,l = i,j
            while k>=0 and l>=0:
                if self.boolRes[k][l]:
                    return False
                k -= 1
                l -= 1
            return True
        backtrack(0,n)
        return self.res