#time complexity: O(m*n*3^L)
        #Space complexity: O(L)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        
        self.dirs = [(-1,0),(1,0),(0,1),(0,-1)]
        if len(board) == 0:
            return False
        def backtrack(board,word,i,j,index):
            #base
            #if all chars match
            if index == len(word):
                return True
            #if char doesnt match or out of bounds, return False
            if i<0 or j<0 or i>= len(board) or j>= len(board[0]) or board[i][j] != word[index]:
                return False
            #logic
            #save as temp, mark as # so we don't go through it again
            temp = board[i][j]
            board[i][j] = '#'
            for d in self.dirs:
                ni = i + d[0]
                nj = j + d[1]
                # if rest of the word matches, return True
                if backtrack(board,word,ni,nj,index+1):
                    return True
            #backtrack
            board[i][j] = temp
            return False
        for i in xrange(len(board)):
            for j in xrange(len(board[0])):
                #parse through each element of matrix, if true at any instance, return true
                    if backtrack(board,word,i,j,0):
                        return True
        return False