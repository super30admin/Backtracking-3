#Time compleixty will be O(3^L) where L is the length of the string
#Space complexity will be O(L) where L is the length of the word
#Program ran successfully on leetcode
#No issues faced while coding
class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if(board==None):
            return False
        #Directions list
        self.dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        #no of rows
        self.m=len(board)
        #no of columns
        self.n=len(board[0])
        #iterating through each value in the board and checking if the required word is formed
        #as per the requirement
        for i in range(0,self.m):
            for j in range(0,self.n):
                if(self.backtrack(word,board,0,i,j)):
                    return True
        #we will return false, if we donot get true in the above case
        return False
    
    def backtrack(self,word,board,idx,i,j):
        #base
        #If index becomes equal to the length of the word, we will return True
        if(idx==len(word)):
            return True
        #if the boundary conditions are not satisfied, we will return False
        if(i<0 or j<0 or i==self.m or j==self.n or board[i][j]=='#'):
            return False
        #logic
        #If the condition is satisfied, we will update the value to #
        if(board[i][j]==word[idx]):
            #action
            board[i][j]='#'
            #recurse
            #we will move in diretions as specified in the directions list and we will check thriugh recursion
            for dir in self.dirs:
                nr=dir[0]+i
                nc=dir[1]+j
                if(self.backtrack(word,board,idx+1,nr,nc)):
                    return True
            #backtrack
            #updating the # to original value
            board[i][j]=word[idx]
        #We will return False if above conditions are not satisfied
        return False


