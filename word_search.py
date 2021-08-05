#Time Complexity: O(exponential).
#Auxiliary Space: O(W)
#Did this code successfully run on Leetcode :Yes
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if len(board)==0:
            return False
        m= len(board)
        n  = len(board[0])
        w = len(word)
        dirs = [[0,-1],[0,1],[1,0],[-1,0]]
        
        def helper(r,c,index):
            if index == w:
                return True
            if  (r <0 or r>=m) or (c<0 or c>=n) or board[r][c] != word[index]:
                return False
            temp = board[r][c]
            board[r][c]= '#' #action
            for item in dirs:
                r1 = r+item[0]
                c1 = c+item[1]
                if helper(r1,c1,index+1):
                    return True
            
            board[r][c] = temp
            return False
        
        for row in range(m):
            for col in range(n):
                if board[row][col] != word[0]:
                    continue
                if helper(row,col,0):
                    return True
        return False
    