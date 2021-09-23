# // Time Complexity :O(m*n*(3^l))m,n dimensions of grid l level
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach



class Solution:
    def __init__(self):
        self.dir=[[0,1],[0,-1],[1,0],[-1,0]]
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                    print(i)
                    if self.helper(word,board,i,j,0):
                        return True
                    
                    
    def helper(self,word,board,r,c,index):
        #base
        if index == len(word):
            return True
        if(r<0 or c<0 or r>=len(board) or c>=len(board[0]) or word[index] is not board[r][c]):
            return False
        #logic
        if board[r][c]==word[index]:
            ch=board[r][c]
            board[r][c]='#'
        for i in self.dir:
            nr=r+i[0]
            nc=c+i[1]
            if self.helper(word,board,nr,nc,index+1):
                    return True
        board[r][c]=ch
            
            
        