
# run i from 0 to rows and j from 0 to cols and check if the element at board[i][j] is the 
# char at word[0]. If it is, call the recursive function backtrack() and return true if the 
# recursive function returns true. By default return false.

# Recursive function:
# Check if the ind reached len of word. If it does, return true. If i or j is out of bounds, return
# false. If the element at board(i,j)==word[index], change the eleemt there to a const and 
# iteratr through 4 directions. In each direction call backyracking with index+1 and return True 
# if the call returns true. Then remove the const from the board by replacing it with the element
# at word(ind). By default return false.

# Time O(m*n)*3^

# Space O(n)

class Solution(object):    

        def backtrack(self,board,i,j,ind,word):

            if ind==len(word):
                return True
            if i<0 or j<0 or i==len(board) or j ==len(board[0]):
                return False
          
            if board[i][j]==word[ind]:
                board[i][j]='*'
                for d in self.direc:
                    nr=i+d[0]
                    nc=j+d[1]
                    if self.backtrack(board,nr,nc,ind+1,word):
                        return True
                board[i][j]=word[ind]
            return False


        def exist(self, board, word):
                """
                :type board: List[List[str]]
                :type word: str
                :rtype: bool
                """
                self.direc=[[0,1],[1,0],[-1,0],[0,-1]]
                m=len(board)
                n=len(board[0])
                for i in range(m):
                    for j in range(n):
                        if board[i][j]==word[0]:
                            if self.backtrack(board,i,j,0,word):
                                return True
                        
                return False

                