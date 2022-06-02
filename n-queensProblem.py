'''
Remember: If I am able to place the queen into a particular row,
1. Abandon the exceution for that row i.e. parent row inside the recursion-stack and over
to the next row
2. If not able to place the queen anywhere into the row, recursively roll-back to the parent 
row, rollback to the previous value for the particular cell and continue
'''

'''
Time Complexity  : factorial(n)
Space Complexity : N*N matrix initialization 0(n^2)
                   recursive stack 0(n)
On Leet-code: Yes
'''
class Solution:
    
    def __init__(self):
        self.resultList = []
    
    def canBePlaced(self,board,row,col):
        
        # chk "Q" at the top
        itr_r = row
        while itr_r >= 0:
            if board[itr_r][col] == "Q":
                return False
            itr_r -= 1
        
        # chk "Q" at the top-right
        itr_r = row
        itr_c = col
        while itr_r >= 0 and itr_c < len(board[row]):
            if board[itr_r][itr_c] == "Q":
                return False
            itr_r -= 1
            itr_c += 1
        
        # chk "Q" at the top-left
        itr_r = row
        itr_c = col
        while itr_r >= 0 and itr_c >= 0:
            if board[itr_r][itr_c] == "Q":
                return False
            itr_r -= 1
            itr_c -= 1
        
        # default return
        return True        
    
    def placeQueen(self,board,row):
        
        # base-case
        if row == len(board):
            
            # create a tempList
            tempList = [None] * len(board)
            
            # I have my n-queens in non-attacking formation
            for i in range(0,len(board)):
                tempStr = ''
                for j in range(0,len(board[i])):
                    if board[i][j] == "Q":
                        tempStr += 'Q'
                    else:
                        tempStr += '.'
                
                # my tempStr is ready!!
                tempList[i] = str(tempStr)
            
            # append the tempList into the resultList
            self.resultList.append(tempList)
            return
                
        # logic-case
        # Iterate the row
        for col in range(0,len(board)):
            flag = self.canBePlaced(board,row,col)
            
            # chk flag result and decide
            if flag == True:
                # I can place -- action
                board[row][col] = "Q"
                
                # do recursive call -- recursive
                self.placeQueen(board,row+1)
                
                # rollback to previous state
                board[row][col] = None
            
            # if flag == False; go-to the next col
        
        # exited for-loop; go-back to the parent in recursive stack
        return
        
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        # initialize a board
        board = [[None for col in range(0,n)] for row in range(0,n)]
        
        # call the function
        self.placeQueen(board,0)
        
        # check the result
        # print(self.resultList)
        return self.resultList