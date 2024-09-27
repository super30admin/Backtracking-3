#Time Complexity:O()
#Space Complexity:

#Algorithm:
# Here we will be using recursion at each left out word string in board and willmutate the given array  to keep track if index has been visited already and also we will write a recursive  function with base case that if we reach the end of string we return true we need to consider five edge cases : 

# a) The fist char matches and there are no chars left in string then 

# b) We are at the right edge of board so can not move right 

# c) We are at the left edge of board so can not move left

# d) We are at the bottom edge of board so can not move down 

# e) We are at the top edge of board so can not move up 

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or len(board)==0:
            return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                # if board[i][j]==word[0]:
                   if self.helper(board,i,j,word):
                        return True
        return False
    
    def helper(self,board,i,j,word):
        #base
        if i <0 or i>len(board)-1 or j<0 or j> len(board[0])-1 or board[i][j]=='#':
             return False
        if len(word)==0:
            return True
         

       
        #logic
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]  
        if board[i][j]==word[0]:
            if len(word)==1:
                return True
            temp=board[i][j]
            board[i][j]='#'
            for dx,dy in dirs:
                r=dx+i
                c=dy+j
                if  self.helper(board,r,c,word[1:]):
                    return True
            board[i][j]=temp
            
        return False
