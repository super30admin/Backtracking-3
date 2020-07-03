# Time Complexity :O(m*n * 3^L)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def backtrack(self,board,word,index,i,j):
        #base#
        # if all word was found return true
        if index >= len(word):
            return True
        # if you go out of bounds or loop return false
        if i < 0 or j < 0 or i == len(board) or j == len(board[0]) or board[i][j] == '#':
            return False
        #logic#
        #if you found a letter from word
        if board[i][j] == word[index]:
            #action
            #save letter
            temp = board[i][j] 
            #mark that you saw it
            board[i][j] = '#'
            #recurse
            #recurse on all directions
            directions = [[1,0],[-1,0],[0,1],[0,-1]]
            for direction in directions:
                row = i + direction[0]
                col = j + direction[1]
                #if any direction return true then return true
                if self.backtrack(board,word,index+1,row,col): return True
            #backtrack
            #change the position to the letter it had before backtracking
            board[i][j] = temp
        # return False if non reach the end of word
        return False
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        #try all the starting points
        for i in range(len(board)):
            for j in range(len(board[0])):
                # if any gives you a true return true
                if self.backtrack(board,word,0,i,j):
                    return True
    
        #return false otherwise
        return False