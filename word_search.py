class Solution(object):
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        #3^(length of word)#exponential >3 choices to go and find char >continues over word length
        #O(length of word)>stack size
        self.m=len(board)
        self.n=len(board[0])
        self.dirs=[[0,1],[1,0],[0,-1],[-1,0]]
        if not board:
            return False
        def helper(board,word,row,col,index):
            if index==len(word):
                return True
            #if already visited or out of bounds>False
            if row<0 or row>=self.m or col<0 or col>=self.n or board[row][col]=="#":
                return False
            #find first matching char and thereby progress
            if board[row][col]==word[index]:
                #action
                #first store temp value of index so that we can backtrack later
                temp=board[row][col]
                board[row][col]='#'
                #check in every direction >neighbours for 2nd matched char
                for dir in self.dirs:
                    r=row+dir[0]
                    c=col+dir[1]
                    #recurse
                    if helper(board,word,r,c,index+1):
                        #extra line just to retrieve original matrix back>
                        board[row][col]=temp
                        return True
                #backtrack
                board[row][col]=temp
            return False
        for i in range(self.m):
            for j in range(self.n):
                #when found first matched char>recurse to find next
                if helper(board,word,i,j,0):
                    return True
        return False
        
        